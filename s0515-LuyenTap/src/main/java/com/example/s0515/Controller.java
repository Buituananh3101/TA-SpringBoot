package com.example.s0515;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private Calculator c;

//    // Cách thông thường
//    public Controller(Calculator c){
//        this.c= new Calculator();
//    }

    // Cách Spring
    @Autowired
    public Controller(@Qualifier("getCalculator") Calculator c){ // Nhớ để @Q để ko lỗi tiềm ẩn, xác định chính xác bean
        this.c= c;
    }
    // http://localhost:8080/tinhCBH?value=9 như này test mới ko lỗi
    @GetMapping("/tinhCBH")
    public String tinhCBH(@RequestParam("value") double x){
        return "KQ "+ c.canBacHai(x);
    }

    @GetMapping("/tinhBP")
    public String tinhBP(@RequestParam("value") double x){
        return "KQ "+ c.binhPhuong(x);
    }
}
