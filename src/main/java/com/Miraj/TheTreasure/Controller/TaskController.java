package com.Miraj.TheTreasure.Controller;

import com.Miraj.TheTreasure.Model.Task;
import com.Miraj.TheTreasure.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping("/getAllTask")
    public ResponseEntity<List<Task>> getAllTasks(){
        return new ResponseEntity<>(service.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/getTask/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable int taskId){
        Task task = service.getTaskById(taskId);

        if(task != null){
            return new ResponseEntity<>(task,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addTask")
    public ResponseEntity<?> addTask(@RequestBody Task task){
        try{
            Task task1 = service.addTask(task);
            return new ResponseEntity<>(task1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateTask/{taskId}")
    public ResponseEntity<?> updateTask(@PathVariable int taskId,@RequestBody Task task) throws Exception {
        Task task1 = service.updateTask(taskId,task);
        if (task1 != null) {
            return new ResponseEntity<>(task,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("task not found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable int taskId){
        Boolean isDeleted = service.deleteTask(taskId);
        if(isDeleted){
            return new ResponseEntity<>("Task is deleted", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
        }
    }
}
