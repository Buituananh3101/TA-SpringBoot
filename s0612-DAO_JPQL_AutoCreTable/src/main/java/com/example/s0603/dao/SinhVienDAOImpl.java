package com.example.s0603.dao;

import com.example.s0603.entity.SinhVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public SinhVien getById(int id) {
        return entityManager.find(SinhVien.class, id);
    }

    // JPQL Functions
    @Override
    public List<SinhVien> getAll() {
        String jpql = "select s from SinhVien s ";
        return this.entityManager.createQuery(jpql, SinhVien.class).getResultList();
    }

    @Override
    public List<SinhVien> getByName(String ten){
        String jpql = "select s from SinhVien s where s.ten = :ten";
        TypedQuery<SinhVien> query = entityManager.createQuery(jpql, SinhVien.class);
        query.setParameter("ten", ten);
        return query.getResultList();
    }

    @Override
    public SinhVien updateTen(SinhVien sinhVien){
        return this.entityManager.merge(sinhVien);
    }

    @Override
    public int updateAllTen(String ten){
        String jpql = "update SinhVien s set s.ten=:tuna";
        Query query = entityManager.createQuery(jpql);
//      Query query = entityManager.createQuery(jpql,  SinhVien.class); Sai
        query.setParameter("tuna", ten);
        return query.executeUpdate();
    }

    @Override
    public void delete(int id) {
        SinhVien s = this.getById(id);
        this.entityManager.remove(s);
    }

    @Override
    public void deleteByTen(String ten) {
        String jpql = "delete from SinhVien s where s.ten = :t";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("t", ten);
        query.executeUpdate();
    }
}
