package com.sqa.plannet.model;

import java.lang.String;

public class Session {
    private int sessionID;
    private int timetableID;
    private int subjectID;
    private String sessionTitle;
    private String startTime;
    private String endTime;
    private String date;
    private String weekDay;
    private String location;
    private String type;

    public Session(int timetableID, int subjectID, int i, String sqa, String endTime, String date, String mon, String location, String lecture) {
    }

    public Session(int sessionID, int timetableID, int subjectID, String sessionTitle, String startTime, String endTime, String date, String weekDay, String location, String type) {
        this.sessionID = sessionID;
        this.timetableID = timetableID;
        this.subjectID = subjectID;
        this.sessionTitle = sessionTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.weekDay = weekDay;
        this.location = location;
        this.type = type;
    }
    public Session( int timetableID, int subjectID, String sessionTitle, String startTime, String endTime, String date, String weekDay, String location, String type) {

        this.timetableID = timetableID;
        this.subjectID = subjectID;
        this.sessionTitle = sessionTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.weekDay = weekDay;
        this.location = location;
        this.type = type;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }
}