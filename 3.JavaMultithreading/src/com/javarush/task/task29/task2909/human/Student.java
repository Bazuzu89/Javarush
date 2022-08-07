package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson {
    private int course;
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);

        this.averageGrade = averageGrade;
    }



    @Override
    public String getPosition() {
        return "Студент";
    }


    public void live() {
        learn();
    }

    public void learn() {
    }

    public void incAverageGrade(double delta) {
        double newAverageGrade = getAverageGrade() + delta;
        setAverageGrade(newAverageGrade);
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public void setBeginningOfSession(Date beginningOfSession) {
        this.beginningOfSession = beginningOfSession;
    }

    public void setEndOfSession(Date endOfSession) {
        this.endOfSession = endOfSession;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public int getCourse() {
        return course;
    }
}