package TI.s054_Autowired_Qualifier.rest;

import TI.s054_Autowired_Qualifier.service.MessageInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Notification1Controller {

    private MessageInterface service;
    private MessageInterface servic2; // Thêm 1 thuộc tính nữa

    @Autowired
    public Notification1Controller(
            @Qualifier("email") MessageInterface service,
            @Qualifier("email") MessageInterface servic2) { // Sửa cons tương ứng
        this.service = service;
        this.servic2 = servic2;
    }

    @GetMapping("/send-message")
    public String sendMessage() {
        return service.sendMessage() + " 1";
    }

    //Thêm 1 endpoint để test khi ko cấu hình j hết thì scope mặc định đúng là singleton ko
    //Nếu true là singleton, false là prototype --> true
    //Bây giờ sẽ vào Emailservice và thêm @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //Trước tên quan sát terminal ta thấy Cons của emailsv được gọi 2 lần --> tạo 2 obj khác nhau
    //Lúc này kết quả so sánh --> flase
    @GetMapping("/check")
    public String check() {
        return "Kết quả so sánh:" + (service == servic2);
    }
}
