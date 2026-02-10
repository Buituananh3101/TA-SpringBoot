package TI.s054_Autowired_Qualifier.rest;

import TI.s054_Autowired_Qualifier.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notification2Controller {

    private MessageInterface emailService;
    private MessageInterface zaloService;

    @Autowired
    public Notification2Controller(
            @Qualifier("email") MessageInterface emailService,
            @Qualifier("zalo") MessageInterface zaloService) {

        this.emailService = emailService;
        this.zaloService = zaloService;
    }

    @GetMapping("/email")
    public String sendEmail(){
        return emailService.sendMessage();
    }

    @GetMapping("/zalo")
    public String sendZalo(){
        return zaloService.sendMessage();
    }
}
