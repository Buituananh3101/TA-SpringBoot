package com.example.s0801.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students") // Tên bảng trong database
public class Student {  // Tên bảng trong code

    // 1. Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Chiến lược tạo id tự động
    @Column(name="id") // Tên cột trong database
    private int id;    // Tên cột trong code

    @Column(name="last_name", length=45)
    private String lastName;

    @Column(name="first_name", length=45)
    private String firstName;

    @Column(name="email", length=45)
    private String email;

    // 2. Cons

    public Student() {}
    public Student(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }
    public Student(int id, String lastName, String firstName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    // 3. Get set

    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // 4. toString

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
