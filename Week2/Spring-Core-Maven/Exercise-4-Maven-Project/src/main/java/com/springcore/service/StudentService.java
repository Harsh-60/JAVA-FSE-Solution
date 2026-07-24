package com.springcore.service;

import com.springcore.model.Student;

public class StudentService {

    public void displayStudent(Student student) {

        System.out.println("Student Details");

        System.out.println("------------------------");

        System.out.println("ID      : " + student.getId());

        System.out.println("Name    : " + student.getName());

        System.out.println("Course  : " + student.getCourse());

    }
}
