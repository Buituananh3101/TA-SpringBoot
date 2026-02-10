package com.example.s0603.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sinhvien")
public class SinhVien {
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// Tự động tăng
    @Column(name = "id")
    private int id;

    @Column(name = "ho_dem", length = 45)
    private String hoDem;

    @Column(name = "ten", length = 45)
    private String ten;

    @Column(name = "email", length = 45)
    private String email;

    // Có thuộc tính, có Cons thì nó sẽ tạo lên tư duy điền vào bảng trong db

    // Bắt buộc có Cons rỗng

    public SinhVien() {
    }

    public SinhVien(int id, String hoDem, String ten, String email) {
        this.id = id;
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
    }

    public SinhVien(String hoDem, String ten, String email) {
        this.hoDem = hoDem;
        this.ten = ten;
        this.email = email;
    }

    // Getters, setters

    public int getId() {
        return id;
    }

    public String getHoDem() {
        return hoDem;
    }

    public String getTen() {
        return ten;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHoDem(String hoDem) {
        this.hoDem = hoDem;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString

    @Override
    public String toString() {
        return "SInhVien{" +
                "id=" + id +
                ", hoDem='" + hoDem + '\'' +
                ", ten='" + ten + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
