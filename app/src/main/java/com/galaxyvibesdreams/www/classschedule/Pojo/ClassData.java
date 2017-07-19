package com.galaxyvibesdreams.www.classschedule.Pojo;

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



    public ClassData(int classId, String classTitle, String classInstitute, String classLocation, String classStartTime, String classEndTime, String classNotes,String classDays) {
        this.classId = classId;
        this.classTitle = classTitle;
        this.classInstitute = classInstitute;
        this.classLocation = classLocation;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classDays = classDays;
        this.classNotes = classNotes;
    }
    public ClassData( String classTitle, String classInstitute, String classLocation, String classStartTime, String classEndTime, String classNotes,String classDays) {

        this.classTitle = classTitle;
        this.classInstitute = classInstitute;
        this.classLocation = classLocation;
        this.classStartTime = classStartTime;
        this.classEndTime = classEndTime;
        this.classDays = classDays;
        this.classNotes = classNotes;
    }

    public ClassData() {

    }

    public void setClassEndTime(String classEndTime) {
        this.classEndTime = classEndTime;
    }

    public String getClassEndTime() {
        return classEndTime;
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

    @Override
    public String toString() {
        return "ClassData{" +
                "classDays='" + classDays + '\'' +
                ", classId=" + classId +
                ", classTitle='" + classTitle + '\'' +
                ", classInstitute='" + classInstitute + '\'' +
                ", classLocation='" + classLocation + '\'' +
                ", classStartTime='" + classStartTime + '\'' +
                ", classNotes='" + classNotes + '\'' +
                '}';
    }
}
