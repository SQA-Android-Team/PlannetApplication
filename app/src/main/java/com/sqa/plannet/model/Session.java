package com.sqa.plannet.model;

import java.io.Serializable;
import java.lang.String;

public class Session implements Serializable {
    private int sessionID;
    private String sessionTitle;
    private String type;
    private String location;
    private String weekDay;
    private String startTime;
    private String endTime;
    private String color;

    public Session() {
    }

    public Session(int sessionID, String sessionTitle, String type, String location, String weekDay, String startTime, String endTime, String color) {
        this.sessionID = sessionID;
        this.sessionTitle = sessionTitle;
        this.type = type;
        this.location = location;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.color = color;
    }

    public Session(String sessionTitle, String type, String location, String weekDay, String startTime, String endTime, String color) {
        this.sessionTitle = sessionTitle;
        this.type = type;
        this.location = location;
        this.weekDay = weekDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.color = color;
    }

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public String getSessionTitle() {
        return sessionTitle;
    }

    public void setSessionTitle(String sessionTitle) {
        this.sessionTitle = sessionTitle;
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

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

//    public Session() {
//    }
//
//    public Session(int sessionID, String sessionTitle, String type, String location , String weekDay, String startTime, String endTime,  String color) {
//        this.sessionID = sessionID;
//        this.sessionTitle = sessionTitle;
//        this.type = type;
//        this.location = location;
//        this.weekDay = weekDay;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.color = color;
//    }
//
//    public Session( String sessionTitle, String type, String location , String weekDay, String startTime, String endTime,  String color) {
//        this.sessionTitle = sessionTitle;
//        this.type = type;
//        this.location = location;
//        this.weekDay = weekDay;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.color = color;
//    }
//
//    public int getSessionID() {
//        return sessionID;
//    }
//
//    public void setSessionID(int sessionID) {
//        this.sessionID = sessionID;
//    }
//
//    public String getSessionTitle() {
//        return sessionTitle;
//    }
//
//    public void setSessionTitle(String sessionTitle) {
//        this.sessionTitle = sessionTitle;
//    }
//
//    public String getStartTime() {
//        return startTime;
//    }
//
//    public void setStartTime(String startTime) {
//        this.startTime = startTime;
//    }
//
//    public String getEndTime() {
//        return endTime;
//    }
//
//    public void setEndTime(String endTime) {
//        this.endTime = endTime;
//    }
//
//    public String getWeekDay() {
//        return weekDay;
//    }
//
//    public void setWeekDay(String weekDay) {
//        this.weekDay = weekDay;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//}