package com.project.portfolio.TheTaskManager.controllers;
import com.project.portfolio.TheTaskManager.entities.Task;
import com.project.portfolio.TheTaskManager.services.taskServices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/task-manager/task")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<String> addTask(@RequestBody Task task){
      boolean isTaskValid = taskService.addTask(task);
     if(isTaskValid){
         return ResponseEntity.ok("Task: " + task.toString() + " added");
     }
      return ResponseEntity.badRequest().body("The task must have at least a title and a description");
    }



    @GetMapping("/show-all")
    public ResponseEntity<List<Task>> showAllTasks() {
        List<Task> tasks = taskService.showAllTasks();
        if (tasks.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(tasks);
        }
    }





}
