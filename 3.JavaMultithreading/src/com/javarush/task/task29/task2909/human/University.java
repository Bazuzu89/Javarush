package com.javarush.task.task29.task2909.human;
import java.util.List;
import java.util.ArrayList;

public class University {
    private List<Student> students;
    private String name;
    private int age;
    public University(String name, int age) {
        this.name = name;
        this.age = age;
        students = new ArrayList<>();
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        Student studentWithAverageGrade = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                studentWithAverageGrade = student;
                break;
            }
        }
        return studentWithAverageGrade;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        Student studentWithMaxAverageGrade = null;
        double maxAverageGrade = 0;
        for (Student student : students) {
            if (student.getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = student.getAverageGrade();
                studentWithMaxAverageGrade = student;
            }
        }
        return studentWithMaxAverageGrade;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        Student studentWithMinAverageGrade = null;
        double minAverageGrade = Double.MAX_VALUE;
        for (Student student : students) {
            if (student.getAverageGrade() < minAverageGrade) {
                minAverageGrade = student.getAverageGrade();
                studentWithMinAverageGrade = student;
            }
        }
        return studentWithMinAverageGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}