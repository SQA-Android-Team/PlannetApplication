package com.sqa.plannet.model;

import java.sql.Date;

public class Timetable {
    private int timetableID;
    private String title;
    private Date startDate;
    private Date endDate;

    public Timetable(int timetableID, String title, Date startDate, Date endDate) {
        this.timetableID = timetableID;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Timetable() {
    }

    public int getTimetableID() {
        return timetableID;
    }

    public void setTimetableID(int timetableID) {
        this.timetableID = timetableID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
