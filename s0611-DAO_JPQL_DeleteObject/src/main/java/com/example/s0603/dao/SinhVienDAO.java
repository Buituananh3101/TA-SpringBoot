package com.example.s0603.dao;

import com.example.s0603.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    // làm sao để lưu 1 sv xuống?
    public void save(SinhVien sinhVien);

    public SinhVien getById(int id);

    public List<SinhVien> getAll();

    public List<SinhVien> getByName(String name);

    // Đổi tên 1 sinh viên
    public SinhVien updateTen(SinhVien sinhVien);

    // Đổi tên tất cả sinh viên thành 1 tên giống nhau
    public int updateAllTen(String ten);

    public void delete(int id);

    public void deleteByTen(String ten);

}
