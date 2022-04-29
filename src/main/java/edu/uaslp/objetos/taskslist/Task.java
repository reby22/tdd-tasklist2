package edu.uaslp.objetos.taskslist;

import java.time.DateTimeException;
import java.time.LocalDateTime;

public class Task {
    private String title, description;
    private LocalDateTime dateTime;
    private boolean sDone;

    public Task(String title, String description, LocalDateTime dateTime, boolean sDone) {
        this.title =title;
        this.description = description;
        this.dateTime = dateTime;
        this.sDone = sDone;
    }

    public Task() {

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public LocalDateTime getDueDate() {
        return this.dateTime;
    }

    public boolean isDone() {
        return this.sDone;
    }

    public void setDueDate(LocalDateTime lclTime) {
        LocalDateTime now=LocalDateTime.now();

        if(lclTime.isBefore(now)){
            throw new TaskListException("Due date is set in the past");
        }
        this.dateTime = lclTime;
    }

    public void setDone(boolean sDone) {
        this.sDone = sDone;
    }
}