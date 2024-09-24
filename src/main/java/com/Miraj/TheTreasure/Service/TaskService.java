package com.Miraj.TheTreasure.Service;

import com.Miraj.TheTreasure.Model.Task;
import com.Miraj.TheTreasure.Repository.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private Task task;


    @Autowired
    repository repository;
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTaskById(int taskId) {
        return repository.findById(taskId).orElse(null);
    }

    public Task addTask(Task task) throws Exception {
        Date today = new Date(System.currentTimeMillis());
        if(task.getDeadline().before(today)){
            throw new Exception("The dealine is not valid.");
        }else{
            return repository.save(task);
        }
    }

    public Task updateTask(int taskId,Task task) throws Exception {
        repository.findById(taskId).orElse(addTask(task));
        return repository.save(task);
    }

    public Boolean deleteTask(int taskId) {
        Optional<Task> task1 = repository.findById(taskId);
        if (task1 != null) {
            repository.deleteById(taskId);
            return true;
        }else{
            return false;
        }
    }
}
