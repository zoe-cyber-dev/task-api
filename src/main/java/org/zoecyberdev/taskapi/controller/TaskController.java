package org.zoecyberdev.taskapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zoecyberdev.taskapi.dto.TaskDto;
import org.zoecyberdev.taskapi.service.impl.TaskServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;

    // Add Task REST API
    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid @RequestBody TaskDto taskDto){
        TaskDto savedTask = taskService.createTask(taskDto);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    // Get Task REST API
    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId){
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    // Get All Tasks REST API
    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks(){
        List<TaskDto> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // Update Task REST API
    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long taskId, @Valid @RequestBody TaskDto updatedTask){
        TaskDto taskDto = taskService.updateTask(taskId, updatedTask);
        return ResponseEntity.ok(taskDto);
    }

    // Delete Task REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully.");
    }

}
