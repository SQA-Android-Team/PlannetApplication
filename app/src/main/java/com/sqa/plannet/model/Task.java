package com.sqa.plannet.model;

import java.io.Serializable;

public class Task implements Serializable {
   private int id;
   public String title ;
   public String type;

   private String location;
   public String time;
   public String date;
   private String note;
   private int remind;
   private int important;

   public Task(){}

    public Task(int id, String title, String type, String location, String time, String date, String note, int remind, int important) {
        this.id = id;
        this.title = title;
        this.type = type;

        this.location = location;
        this.time = time;
        this.date = date;
        this.note = note;
        this.remind = remind;
        this.important = important;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRemind() {
        return remind;
    }

    public void setRemind(int remind) {
        this.remind = remind;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +

                ", location='" + location + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", note='" + note + '\'' +
                ", remind=" + remind +
                ", important=" + important +
                '}';
    }
}
