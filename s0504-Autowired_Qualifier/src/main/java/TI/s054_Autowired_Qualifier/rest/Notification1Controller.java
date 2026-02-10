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
    public Notification1Controller(@Qualifier("zalo") MessageInterface service) {
        this.service = service;
    }

    @GetMapping("/send-message")
    public String sendMessage() {
        return service.sendMessage() + " 1";
    }
}
