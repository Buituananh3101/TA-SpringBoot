package com.example.s0603.dao;

import com.example.s0603.entity.SinhVien;

import java.util.List;

public interface SinhVienDAO {
    // làm sao để lưu 1 sv xuống?
    public void save(SinhVien sinhVien);

    public SinhVien getById(int id);

    public List<SinhVien> getAll();

    public List<SinhVien> getByName(String name);
}
