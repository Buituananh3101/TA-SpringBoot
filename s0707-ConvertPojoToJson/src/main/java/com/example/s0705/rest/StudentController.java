package com.example.s0705.rest;

import com.example.s0705.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    public List<Student> ds;

    @PostConstruct
    public void createList(){
        ds =  new ArrayList<Student>();
        ds.add(new Student(1,"a",1,"a","a"));
        ds.add(new Student(2,"b",1,"b","b"));
        ds.add(new Student(3,"c",1,"c","c"));
        ds.add(new Student(4,"d",1,"d","d"));
        ds.add(new Student(5,"e",1,"e","e"));
        ds.add(new Student(6,"f",1,"f","f"));
        ds.add(new Student(7,"g",1,"g","g"));
        ds.add(new Student(8,"h",1,"h","h"));

    }

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return ds;
    }

}
