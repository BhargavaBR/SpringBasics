package com.training.springbasics.TaskManagerV2.Service;

import com.training.springbasics.TaskManagerV2.Exception.ExceptionResponseDTO;
import com.training.springbasics.TaskManagerV2.Task;
import com.training.springbasics.TaskManagerV2.dto.CreateTaskDTO;
import com.training.springbasics.TaskManagerV2.dto.TaskResponseDTO;
import com.training.springbasics.TaskManagerV2.dto.UpdateTaskDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final List<Task> list = new ArrayList<>();
    private final Date currentDate;

    {
        try {
            currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private int id =0;
    public List<Task> getTasks() {
        return list;
    }
    public Task getTaskById(int id) {
        for(Task task : list){
            if(task.getId() == id){
                return task;
            }
        }
        throw new TaskNotFoundException("Task not found");
    }

    public Object addTask(CreateTaskDTO createTaskDTO) throws ParseException {
        ExceptionResponseDTO exceptionResponseDTO;
        Task task = new Task();
        task.setId(++id);
        task.setCompleted(false);
        boolean DateValidation = validateDate(createTaskDTO.getDueDate());
        if(!DateValidation){
            exceptionResponseDTO = new ExceptionResponseDTO();
            exceptionResponseDTO.setError("Date is Not valid, pls enter date correctly");
            exceptionResponseDTO.setStatus(200);
            return exceptionResponseDTO;
        }
        if(createTaskDTO.getName() == null || createTaskDTO.getName().length() <5 ||
                createTaskDTO.getName().length()>100){
            exceptionResponseDTO = new ExceptionResponseDTO();
            exceptionResponseDTO.setError("Name Cannot be null or Name length is less than 5 char or greter than 100!");
            exceptionResponseDTO.setStatus(200);
            return exceptionResponseDTO;
        }
        task.setDueDate(createTaskDTO.getDueDate());
        task.setName(createTaskDTO.getName());
        list.add(task);
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setTask(task);
        taskResponseDTO.setResult("Successfully created");
        return taskResponseDTO;
    }



    public Task updateTask(int id, UpdateTaskDTO updateTaskDTO) throws ParseException {
        if(updateTaskDTO.getDueDate() == null || validateDate(updateTaskDTO.getDueDate())) {
            throw new DateException("Date is not valid");
        }
        for(Task task : list){
            if(task.getId() == id){
                task.setDueDate(updateTaskDTO.getDueDate());
                task.setCompleted(updateTaskDTO.getCompleted());
                return task;
            }
        }
        throw new TaskNotFoundException("Task not found");
    }

    public Task deleteTask(int id) {
        for(Task task : list){
            if(task.getId() == id){
                list.remove(task);
                return task;
            }
        }
        throw new TaskNotFoundException("Task not found");
    }

    class DateException extends IllegalStateException{
        public DateException(String message) {
            super(message);
        }
    }
    class NameException extends IllegalStateException{
        public NameException(String message) {
            super(message);
        }
    }
    class TaskNotFoundException extends IllegalStateException{
        public TaskNotFoundException(String message) {
            super(message);
        }
    }
    private boolean validateDate(Date dueDate) throws ParseException {
        Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
        return dueDate.compareTo((currentDate)) > 0;
    }

}
