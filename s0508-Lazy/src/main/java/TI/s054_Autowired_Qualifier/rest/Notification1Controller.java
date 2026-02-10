package TI.s054_Autowired_Qualifier.rest;

import TI.s054_Autowired_Qualifier.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notification1Controller {

    private MessageInterface service;

    @Autowired
    public Notification1Controller(@Qualifier("email") MessageInterface service) {
        this.service = service;
    }

    @GetMapping("/send-message")
    public String sendMessage() {
        return service.sendMessage() + " 1";
    }
}
// Tất cả các @Component đều được tạo hết khi chưa có @Lazy
// Mặc dù mới dùng mỗi email

// thêm @Lazy vào = 1 in 2 cách thì lúc đó dùng cái j nó khởi tạo cái đấy
// Lúc này ko có cons này được tạo hết, khi vào 8000 gọi email thì emai mới được tạo
// (Trong file dùng cách spring.main.lazy-initialization=true)
    