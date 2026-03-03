package com.example.s0801.service;

import com.example.s0801.dao.StudentDAO;
import com.example.s0801.dao.StudentRepository;
import com.example.s0801.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentServive{

//    private StudentDAO studentDAO; // thay bằng:
    private StudentRepository studentRepository;

    // Thấy tất cả studentDAO thành studentRepository
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Khi viết thêm thằng service thì nhớ:
    // tất cả @Transactional ở DAO phải được
    // chuyển sang service

    // Lý giải: Khi thực hiện thay đổi thì hàm thay đổi có th ảnh hưởng đến N thầng DAO
    //          chứ ko chỉ dừng lại ở 1 thằng, vì vậy nếu để ở service thì
    //          nó có thể roll back nhiều thằng DAO

    @Override
    public List<Student> getAllStudents() {
//        return studentDAO.getAll();
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
