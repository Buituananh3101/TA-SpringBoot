package TI.s054_Autowired_Qualifier.service;

import org.springframework.stereotype.Component;

@Component("zalo")
public class ZaloService implements MessageInterface {

//    @Override // Có hay ko cx đc
    public String sendMessage() {
        return "zalo";
    }
}
