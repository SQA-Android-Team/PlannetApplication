package com.sqa.plannet.model;

public class Teacher {
    private int teacherID;
    private String teacherName;
    private String phone;
    private String email;

    public Teacher(int teacherID, String teacherName, String phone, String email) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.phone = phone;
        this.email = email;
    }

    public Teacher() {
    }

    public Teacher(String teacherName) {
        this.teacherName = teacherName;
    }

    public Teacher(String teacherName, String phone, String email) {
        this.teacherName = teacherName;
        this.phone = phone;
        this.email = email;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
