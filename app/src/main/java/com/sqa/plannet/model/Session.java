package com.sqa.plannet.model;

import java.io.Serializable;
import java.lang.String;

public class Session implements Serializable {
    private int sessionID;
    private int timetableID;
    private int subjectID;
    private int teacherID;
    private String sessionTitle;
    private String startTime;
    private String endTime;
    private String weekDay;
    private String location;
    private String type;
    private String color;

    public Session() {
    }

    public Session(int sessionID, int timetableID, int subjectID, int teacherID, String sessionTitle, String startTime, String endTime, String weekDay, String location, String type, String color) {
        this.sessionID = sessionID;
        this.timetableID = timetableID;
        this.subjectID = subjectID;
        this.teacherID = teacherID;
        this.sessionTitle = sessionTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
        this.location = location;
        this.type = type;
        this.color = color;
    }

    public Session(int timetableID, int subjectID, int teacherID, String sessionTitle, String startTime, String endTime, String weekDay, String location, String type, String color) {
        this.timetableID = timetableID;
        this.subjectID = subjectID;
        this.teacherID = teacherID;
        this.sessionTitle = sessionTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
        this.location = location;
        this.type = type;
        this.color = color;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public int getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(int timetableID) {
        this.timetableID = timetableID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getSessionTitle() {
        return sessionTitle;
    }

    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}