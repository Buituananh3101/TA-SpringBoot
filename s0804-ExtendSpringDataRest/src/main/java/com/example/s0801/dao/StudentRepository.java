package com.example.s0801.dao;

import com.example.s0801.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// Chỉ cần đến dấu ** là đã đủ để thay thế hoàn toàn cho StudentDAO & StudentDAOImpl
// có thể xóa 2 file đó đi
@Repository                                             //class   // Khóa chính
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //**
    // Có thể thêm các methods khác

    // Query bằng firstName
    public List<Student> findByFirstName(String firstName);

    // Query bằng lastName & firstName
    public List<Student> findByLastNameAndFirstName(String lastName, String firstName);

//    // Tìm các student khác với firstName tìm kiếm C1
//    public List<Student> findByFirstNameNot(String firstName);

    // Tìm các student khác với firstName tìm kiếm C2
    // <> là đấu khác
    @Query("select s from Student s where s.firstName<>?1")
    public List<Student> findByFirstNameNot(String firstName);


}
