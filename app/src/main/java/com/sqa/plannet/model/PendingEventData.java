package com.sqa.plannet.model;

public class PendingEventData {

    String dateEvent;
    String monthEvent;
    String nameEvent;


    public PendingEventData(String dateEvent, String monthEvent, String nameEvent) {
        this.dateEvent = dateEvent;
        this.monthEvent = monthEvent;
        this.nameEvent = nameEvent;
    }

    public String getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(String dateEvent) {
        this.dateEvent = dateEvent;
    }

    public String getMonthEvent() {
        return monthEvent;
    }

    public void setMonthEvent(String monthEvent) {
        this.monthEvent = monthEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }
}
