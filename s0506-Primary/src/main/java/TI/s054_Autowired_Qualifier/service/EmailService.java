package TI.s054_Autowired_Qualifier.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("email")
@Primary
public class EmailService implements MessageInterface {

    @Override
    public String sendMessage() {
        return "email";
    }
}
