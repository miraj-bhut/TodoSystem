package com.Miraj.TheTreasure.Service;

import com.Miraj.TheTreasure.Model.Task;
import com.Miraj.TheTreasure.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private Task task;


    @Autowired
    Repository repository;
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(int taskId) {
        return repository.findById(taskId).orElse(null);
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public void updateTask(int taskId,Task task){
        repository.findById(taskId).orElse(addTask(task));
        repository.save(task);
    }

    public void deleteTask(int taskId) {
        repository.findById(taskId).orElseThrow(() -> new RuntimeException("No task found"));
        repository.deleteById(taskId);
    }
}
