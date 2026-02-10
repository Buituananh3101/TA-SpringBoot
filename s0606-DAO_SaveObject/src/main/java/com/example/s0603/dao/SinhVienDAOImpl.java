package com.example.s0603.dao;

import com.example.s0603.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // Đánh dấu là 1 nơi hay tương tác lưu/đọc db
@Transactional
public class SinhVienDAOImpl implements SinhVienDAO {
    private EntityManager entityManager;

    @Autowired
    public SinhVienDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(SinhVien sinhVien) { // Lưu 1 sv
        this.entityManager.persist(sinhVien);
    }
}
