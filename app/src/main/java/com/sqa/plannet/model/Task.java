package com.sqa.plannet.model;

public class Task {
   private int id;
   public String title ;
   public String type;
   private String location;
   public String time;
   private String note;
   private boolean remind;
   private boolean important;

   public Task(){}

    public Task(int id, String title, String type, String location, String time, String note, boolean remind, boolean important) {
       super();
        this.id = id;
        this.title = title;
        this.type = type;
        this.location = location;
        this.time = time;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isRemind() {
        return remind;
    }

    public void setRemind(boolean remind) {
        this.remind = remind;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
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
                ", note='" + note + '\'' +
                ", remind=" + remind +
                ", important=" + important +
                '}';
    }
}
