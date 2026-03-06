package com.example.s1407.entity;

import jakarta.persistence.*;

import java.sql.Blob;
import java.util.Date;

@Entity
@Table(name="teacher_detail")
public class TeacherDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="identification_number")
    private String identificationNumber;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="date_of_birth")
    private Date dateOfBirth;

    @Column(name="address")
    private String address;

    @Column(name="gender")
    private boolean gender;

    @Column(name="salary")
    private double salary;

    @Column(name="youtube_channel")
    private String youtubeChannel;

    @Column(name="facebook")
    private String facebook;

    @Column(name="hobby")
    private String hobby;

    @Lob
    @Column(name="avatar")
    private Blob avatar;

    //---------------------------------


    public TeacherDetail() {
    }

    public TeacherDetail(String identificationNumber, String phoneNumber, Date dateOfBirth, String address, boolean gender, double salary, String youtubeChannel, String facebook, String hobby, Blob avatar) {
        this.identificationNumber = identificationNumber;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.gender = gender;
        this.salary = salary;
        this.youtubeChannel = youtubeChannel;
        this.facebook = facebook;
        this.hobby = hobby;
        this.avatar = avatar;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public String getHobby() {
        return hobby;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getYoutubeChannel() {
        return youtubeChannel;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setYoutubeChannel(String youtubeChannel) {
        this.youtubeChannel = youtubeChannel;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "TeacherDetail{" +
                "id=" + id +
                ", identificationNumber='" + identificationNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", facebook='" + facebook + '\'' +
                ", hobby='" + hobby + '\'' +
                ", avatar=" + avatar +
                '}';
    }
}
