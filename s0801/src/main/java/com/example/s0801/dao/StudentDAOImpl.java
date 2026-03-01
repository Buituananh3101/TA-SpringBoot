package com.example.s0801.dao;

import com.example.s0801.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager em;

    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Student> getAll() {
        String jpql = "select s from Student s"; // tên bảng cột theo code, ko theo database
        return em.createQuery(jpql, Student.class).getResultList(); // Tại sao lại có cáo class kia nhỉ
    }

    @Override
    public Student getById(int id) {
        return em.find(Student.class, id); // Hibernate có sẵn find lên dùng luôn
    }

    @Override
//    @Transactional
    public Student save(Student student) {
        em.persist(student); // Hibernate có sẵn persist lên dùng luôn
        return student;
    }

    @Override
//    @Transactional
    public Student saveAndFlush(Student student) {
        student = em.merge(student);
        em.flush();
        return student;
    }

    @Override
//    @Transactional
    public void deleteById(int id) {
        Student s= getById(id);
        em.remove(s);
    }
}
