package TI.s054_Autowired_Qualifier.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ConfigurationBeanNameGenerator;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("email")
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Scope("prototype")
public class EmailService implements MessageInterface {

    @Override
    public String sendMessage() {
        return "email";
    }

    // Thêm Constructor
    public EmailService() {
        System.out.println("Email Service Constructor"+ getClass().getSimpleName());
    }
}
