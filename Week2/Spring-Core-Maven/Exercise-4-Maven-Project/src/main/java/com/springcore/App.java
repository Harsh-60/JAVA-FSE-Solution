package com.springcore;

import com.springcore.model.Student;
import com.springcore.service.StudentService;

public class App {

    public static void main(String[] args) {

        Student student =
                new Student(101,
                        "Harsh Rai",
                        "Computer Science");

        StudentService service = new StudentService();

        service.displayStudent(student);

    }

}
