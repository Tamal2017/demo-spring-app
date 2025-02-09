package com.example.demospringapp.model;

public class Student {
    private int id;
    private String name;
    private String average;

    public Student() {
    }

    public Student(int id, String name, String average) {
        this.id = id;
        this.name = name;
        this.average = average;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAverage() {
        return average;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", average='" + average + '\'' +
                '}';
    }
}
