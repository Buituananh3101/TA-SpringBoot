package TI.s054_Autowired_Qualifier.rest;

import TI.s054_Autowired_Qualifier.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notification1Controller {

    private MessageInterface service;
    private MessageInterface servic2;
    @Autowired
    public Notification1Controller(
            @Qualifier("email") MessageInterface service,
            @Qualifier("email") MessageInterface servic2) {
        this.service = service;
        this.servic2 = servic2;
    }

    @GetMapping("/send-message")
    public String sendMessage() {
        return service.sendMessage() + " 1";
    }

    @GetMapping("/check")
    public String check() {
        return "Kết quả so sánh:" + (service == servic2);
    }
}
