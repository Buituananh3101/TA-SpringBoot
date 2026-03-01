package com.example.s0801.service;

import com.example.s0801.dao.StudentDAO;
import com.example.s0801.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServive{

    private StudentDAO studentDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // Khi viết thêm thằng service thì nhớ:
    // tất cả @Transactional ở DAO phải được
    // chuyển sang service

    // Lý giải: Khi thực hiện thay đổi thì hàm thay đổi có th ảnh hưởng đến N thầng DAO
    //          chứ ko chỉ dừng lại ở 1 thằng, vì vậy nếu để ở service thì
    //          nó có thể roll back nhiều thằng DAO

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.getAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDAO.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentDAO.deleteById(id);
    }
}
