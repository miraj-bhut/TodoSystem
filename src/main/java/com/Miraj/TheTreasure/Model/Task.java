package com.Miraj.TheTreasure.Model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.*;


enum TaskStatus {
    TODO, COMPLETED;
}
enum TaskPriority{
    HIGH, MEDIUM, LOW;
}

@Entity
@Component
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int task_id;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    @Temporal(TemporalType.DATE)
    private Date deadline;
    @Temporal(TemporalType.DATE)
    private Date assigningDate = new Date();


    public Task(int task_id, String description, TaskStatus status, TaskPriority priority, Date deadline, Date assigningDate){
        this.task_id = task_id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.deadline = deadline;
        this.assigningDate = assigningDate;
    }

    public Task(){

    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getAssigningDate() {
        return assigningDate;
    }

    public void setAssigningDate(Date assigningDate) {
        this.assigningDate = assigningDate;
    }

    @Override
    public String toString() {
        try {
            return "Task id: " + task_id + " ,Task description: " + description + "assigning Date: " + assigningDate +", Deadline: " + deadline + ", Status: " + status + " Task Priority: " + priority;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
