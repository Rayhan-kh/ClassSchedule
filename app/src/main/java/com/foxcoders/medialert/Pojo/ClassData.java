package com.foxcoders.medialert.Pojo;

/**
 * Created by Ray on 1/27/2017.
 */

public class ClassData {


    private int classId;
    private String classTitle;
    private String classInstitute;
    private String classLocation;
    private String classStartTime;
    private String classNotes;
    private String classDays;
    private String classEndTime;
    private String classEndTime2;


    public ClassData(int classId, String classTitle, String classInstitute, String classLocation, String classStartTime, String classEndTime, String classEndTime2, String classNotes, String classDays) {
        this.classId = classId;
        this.classTitle = classTitle;
        this.classInstitute = classInstitute;
        this.classLocation = classLocation;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classEndTime2 = classEndTime2;
        this.classDays = classDays;
        this.classNotes = classNotes;
    }

    public ClassData(String classTitle, String classInstitute, String classLocation, String classStartTime, String classEndTime, String classEndTime2, String classNotes, String classDays) {

        this.classTitle = classTitle;
        this.classInstitute = classInstitute;
        this.classLocation = classLocation;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classEndTime2 = classEndTime2;
        this.classDays = classDays;
        this.classNotes = classNotes;
    }

    public ClassData() {

    }

    public String getClassEndTime() {
        return classEndTime;
    }

    public void setClassEndTime(String classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getClassDays() {
        return classDays;
    }

    public void setClassDays(String classDays) {
        this.classDays = classDays;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassLocation() {
        return classLocation;
    }

    public void setClassLocation(String classLocation) {
        this.classLocation = classLocation;
    }

    public String getClassInstitute() {
        return classInstitute;
    }

    public void setClassInstitute(String classInstitute) {
        this.classInstitute = classInstitute;
    }

    public String getClassNotes() {
        return classNotes;
    }

    public void setClassNotes(String classNotes) {
        this.classNotes = classNotes;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public void setClassTitle(String classTitle) {
        this.classTitle = classTitle;
    }

    public String getClassStartTime() {
        return classStartTime;
    }

    public void setClassStartTime(String classStartTime) {
        this.classStartTime = classStartTime;
    }

    public String getClassEndTime2() {
        return classEndTime2;
    }

    public void setClassEndTime2(String classEndTime2) {
        this.classEndTime2 = classEndTime2;
    }
}
