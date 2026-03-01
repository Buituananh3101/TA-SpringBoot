package com.example.s0801.service;

import com.example.s0801.entity.Student;

import java.util.List;

public interface StudentServive {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(int id);

}
