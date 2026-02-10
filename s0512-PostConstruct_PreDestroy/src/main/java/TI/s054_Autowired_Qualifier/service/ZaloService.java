package TI.s054_Autowired_Qualifier.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("zalo")
public class ZaloService implements MessageInterface {


    public String sendMessage() {
        return "zalo";
    }

    // Thêm Constructor
    public ZaloService() {
        System.out.println("Zalo Service Constructor"+ getClass().getSimpleName());
    }
}
