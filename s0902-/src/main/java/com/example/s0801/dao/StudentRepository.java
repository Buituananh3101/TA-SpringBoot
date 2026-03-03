package com.example.s0801.dao;

import com.example.s0801.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// Chỉ cần đến dấu ** là đã đủ để thay thế hoàn toàn cho StudentDAO & StudentDAOImpl
// có thể xóa 2 file đó đi
@Repository                                             //class   // Khóa chính
public interface StudentRepository extends JpaRepository<Student, Integer> {
    //**
    // Có thể thêm các methods khác

    public Student test(); // Lúc Override thì phải
                           // Override lại bằng hết methods mình thêm và
                           // Override bằng hết methods của Jpa


}
