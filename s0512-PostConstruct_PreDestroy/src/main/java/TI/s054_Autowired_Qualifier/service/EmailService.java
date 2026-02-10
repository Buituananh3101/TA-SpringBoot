package TI.s054_Autowired_Qualifier.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.ConfigurationBeanNameGenerator;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("email")
@Scope("singleton")
public class EmailService implements MessageInterface {

    @Override
    public String sendMessage() {
        return "email";
    }

    public EmailService() {
        System.out.println("Email Service Constructor"+ getClass().getSimpleName());
    }

    // Thêm 10 hàm để test thứ tự --> ko theo thứ tự, nó sẽ chạy hết post, pre thôi

    @PostConstruct
    public void init1(){
        System.out.println("init1 run ngay sau cons của "+ getClass().getSimpleName());
    }
    @PostConstruct
    public void init2(){
        System.out.println("init2 run ngay sau cons của "+ getClass().getSimpleName());
    }
    @PostConstruct
    public void init3(){
        System.out.println("init3 run ngay sau cons của "+ getClass().getSimpleName());
    }
    @PostConstruct
    public void init4(){
        System.out.println("init4 run ngay sau cons của "+ getClass().getSimpleName());
    }
    @PostConstruct
    public void init5(){
        System.out.println("init5 run ngay sau cons của "+ getClass().getSimpleName());
    }
    @PreDestroy
    public void delete1(){
        System.out.println("delete1 run ngay trước khi xóa "+ getClass().getSimpleName());
    }
    @PreDestroy
    public void delete2(){
        System.out.println("delete2 run ngay trước khi xóa "+ getClass().getSimpleName());
    }
    @PreDestroy
    public void delete3(){
        System.out.println("delete3 run ngay trước khi xóa "+ getClass().getSimpleName());
    }
    @PreDestroy
    public void delete4(){
        System.out.println("delete4 run ngay trước khi xóa "+ getClass().getSimpleName());
    }
    @PreDestroy
    public void delete5(){
        System.out.println("delete5 run ngay trước khi xóa "+ getClass().getSimpleName());
    }
}
