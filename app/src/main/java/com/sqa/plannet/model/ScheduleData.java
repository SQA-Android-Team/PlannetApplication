package com.sqa.plannet.model;

public class ScheduleData {

    String courseName;
    String professor;
    String room;



    public ScheduleData(String courseName, String professor, String room) {
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
