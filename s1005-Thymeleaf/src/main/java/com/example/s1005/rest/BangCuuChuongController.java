package com.example.s1005.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BangCuuChuongController {

    @GetMapping("/hien-thi/{x}")
    public String hienThiBangCuuChuong(@PathVariable int x, Model model){ //model để ta có thể gửi in4 đi
        model.addAttribute("number", x);
        return "bang-cuu-chuong";// tên file thymeleaf

    }
}
