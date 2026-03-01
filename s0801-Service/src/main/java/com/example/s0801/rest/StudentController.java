package com.example.s0801.rest;

import com.example.s0801.dao.StudentDAO;
import com.example.s0801.entity.Student;
import com.example.s0801.service.StudentServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

//    private StudentDAO studentDAO;
    private StudentServive studentServive;

    @Autowired
    public StudentController(StudentServive studentServive) {
        this.studentServive = studentServive;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return this.studentServive.getAllStudents();
    }

    // Lấy sinh viên theo id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = this.studentServive.getStudentById(id);
        if(student != null) return ResponseEntity.ok(student);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId(0); // Bắt buộc thêm mới và phát sinh ra
                          // Khi set id là 0 tức là yêu cầu tạo ra 1 đối tượng mới
        student = studentServive.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
        Student s = studentServive.getStudentById(id);
        if(s != null){
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setEmail(student.getEmail());
            studentServive.saveStudent(s);
            return ResponseEntity.ok(s);
        }
        else return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id) {
        Student s = studentServive.getStudentById(id);
        if(s != null){
            studentServive.deleteStudent(id);
//            return ResponseEntity.ok(s);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else return ResponseEntity.notFound().build();

    }

}
