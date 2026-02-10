package spring.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {

    @GetMapping("/") // Link truy cập vào hàm, cách truy cập vào 1 API qua hàm get
    public String tuanAnhXinChao(){
        return "Xin Chao";
    }

    @GetMapping("/h2")
    public String tuanAnhXinChao2(){
        return "Xin Chào h2";
    }

}
