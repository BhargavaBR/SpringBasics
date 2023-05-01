package com.training.springbasics.TaskManager;

import java.util.Date;

public class Task {
    private int id;
    private String name;
    private Date dueDate;
    private boolean completed;

    public Task(int id, String name, Date dueDate, boolean completed) {
        this.id = id;
        this.name = name;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Task setId(int id) {
        this.id = id;
        return  this;
    }

    public Task setName(String name) {
        this.name = name;
        return  this;
    }

    public Task setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return  this;
    }

    public Task setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }
}
