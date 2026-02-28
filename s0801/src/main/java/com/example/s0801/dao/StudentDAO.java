package com.example.s0801.dao;

import com.example.s0801.entity.Student;

import java.util.List;

public interface StudentDAO {

    // Lấy toàn bộ danh sách sinh viên
    public List<Student> getAll();

    // Lấy 1 sinh viên theo id
    public Student getById(int id);

    // Lưu 1 sinh viên vào db
    public Student save(Student student);

    // Thay đổi thông tin 1 sinh viên đã tồn tại
    public Student saveAndFlush(Student student);

    // Xóa 1 sinh viên theo id
    public void deleteById(int id);
}
