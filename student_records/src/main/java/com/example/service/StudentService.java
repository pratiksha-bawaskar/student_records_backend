package com.example.service;


import com.example.model.Student;
import java.util.*;

public class StudentService {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
        System.out.println("Student added: " + student);
    }

    public void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students found.");
        } else {
            studentMap.values().forEach(System.out::println);
        }
    }

    public void updateStudent(int id, String name, String course) {
        Student student = studentMap.get(id);
        if (student != null) {
            student.setName(name);
            student.setCourse(course);
            System.out.println("Student updated: " + student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        Student removed = studentMap.remove(id);
        if (removed != null) {
            System.out.println("Student deleted: " + removed);
        } else {
            System.out.println("Student not found.");
        }
    }
}