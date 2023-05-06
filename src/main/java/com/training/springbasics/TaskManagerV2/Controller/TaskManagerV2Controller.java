package com.training.springbasics.TaskManagerV2.Controller;


import com.training.springbasics.TaskManagerV2.Service.TaskService;
import com.training.springbasics.TaskManagerV2.Task;
import com.training.springbasics.TaskManagerV2.dto.CreateTaskDTO;
import com.training.springbasics.TaskManagerV2.dto.TaskResponseDTO;
import com.training.springbasics.TaskManagerV2.dto.UpdateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskManagerV2Controller {
    private final TaskService taskService;
    public TaskManagerV2Controller(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(taskService.getTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable int id){
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    @PostMapping("")
    public ResponseEntity<Object> addTask(@RequestBody CreateTaskDTO createTaskDTO) throws ParseException {
        return ResponseEntity.ok(taskService.addTask(createTaskDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody UpdateTaskDTO updateTaskDTO) throws ParseException {
        return ResponseEntity.ok(taskService.updateTask(id, updateTaskDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id){
        return ResponseEntity.ok(taskService.deleteTask(id));
    }





}
