package com.training.springbasics.TaskManager;

import com.training.springbasics.TaskManager.Exception.IvalidRequestException;
import com.training.springbasics.TaskManager.Exception.TaskNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    List<Task> tasks = new ArrayList<>();
    int nextTask = 0;

    @GetMapping()
    public List<Task> getTasks() {
        return tasks;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException("Task with id " + id+" not found");
    }
    @PutMapping("/update/{id}")
    public Task updateTask(@PathVariable int id, @RequestBody Task task) throws ParseException {
        for(Task t: tasks){
            if(t.getId() == id){
                if(task.getName()!= null)t.setName(task.getName());
                t.setCompleted(task.isCompleted());
                if(task.getDueDate()!= null) t.setDueDate(task.getDueDate());
                return t;
            }
        }
        throw new TaskNotFoundException("Task with id " + id+" not found");
    }

    @DeleteMapping("/delete/{id}")
    public Task deleteTask(@PathVariable int id) throws ParseException {
        for(int i=0;i<tasks.size();i++) {
            if(tasks.get(i).getId() == id){
                Task deletedTask = tasks.get(i);
                tasks.remove(i);
                return deletedTask;
            }
        }
        throw new TaskNotFoundException("Task not found");
    }


    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) throws ParseException {
        Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
        if(task.getDueDate().compareTo((currentDate)) <= 0)
            throw new IvalidRequestException("Date is Invalid");
        if(task.getName()==null)
            throw new IvalidRequestException("Name is required");
        task.setId(++nextTask);
        tasks.add(task);
        return task;
    }

    @GetMapping("/filter/{completed}")
    public List<Task> filterTasks(@PathVariable boolean completed) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted() == completed) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    @GetMapping("/filter/Date/{sort}")
    public List<Task> sortTasks(@PathVariable boolean sort){
        List<Task> sortedTask = new ArrayList<>(tasks);
        if(sort){
            sortedTask.sort((o1, o2) -> o1.getDueDate().compareTo(o2.getDueDate()));
        }
        else {
            sortedTask.sort((o1, o2) -> o2.getDueDate().compareTo(o1.getDueDate()));
        }
        return sortedTask;
    }

    @DeleteMapping("/deleteCompleted")
    public List<Task> deleteCompletedTasks(){
        List<Task> deletedTasks = new ArrayList<>();
        for(int i=0;i<tasks.size();i++){
            if(tasks.get(i).isCompleted()){
                deletedTasks.add(tasks.get(i));
                tasks.remove(i);
            }
        }
        return deletedTasks;
    }

}
