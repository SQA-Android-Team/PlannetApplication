package com.sqa.plannet.model;

import java.sql.Date;

public class Task {
    private int taskID;
    private String taskTitle;
    private String dueDate;
    private String taskNote;
    private String taskType;

    public Task() {
    }

    public Task(int taskID, String taskTitle, String dueDate, String taskNote, String taskType) {
        this.taskID = taskID;
        this.taskTitle = taskTitle;
        this.dueDate = dueDate;
        this.taskNote = taskNote;
        this.taskType = taskType;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
