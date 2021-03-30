package com.sqa.plannet.model;

import java.io.Serializable;

public class Subject implements Serializable {
    private int subjectID;
    private String subjectTitle;
    private String subjectNote;
    private int subjectCredit;
    private float attendance;
    private float midterm;
    private float finalTest;


    public Subject() {
    }

    public Subject(int subjectID, String subjectTitle, String subjectNote, int subjectCredit, float attendance, float midterm, float finalTest) {
        this.subjectID = subjectID;
        this.subjectTitle = subjectTitle;
        this.subjectNote = subjectNote;
        this.subjectCredit = subjectCredit;
        this.attendance = attendance;
        this.midterm = midterm;
        this.finalTest = finalTest;

    }

    public Subject(String subjectTitle){
        this.subjectTitle = subjectTitle;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle;
    }

    public String getSubjectNote() {
        return subjectNote;
    }

    public void setSubjectNote(String subjectNote) {
        this.subjectNote = subjectNote;
    }

    public int getSubjectCredit() {
        return subjectCredit;
    }

    public void setSubjectCredit(int subjectCredit) {
        this.subjectCredit = subjectCredit;
    }

    public float getAttendance() {
        return attendance;
    }

    public void setAttendance(float attendance) {
        this.attendance = attendance;
    }

    public float getMidterm() {
        return midterm;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public float getFinalTest() {
        return finalTest;
    }

    public void setFinalTest(float finalTest) {
        this.finalTest = finalTest;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectID=" + subjectID +
                ", subjectTitle='" + subjectTitle + '\'' +
                ", subjectNote='" + subjectNote + '\'' +
                ", subjectCredit=" + subjectCredit +
                ", attendance=" + attendance +
                ", midterm=" + midterm +
                ", finalTest=" + finalTest +
                '}';
    }
}
