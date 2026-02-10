package s033.CauHinhCong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CauHinhCongApplication {

	@Value("${tuanAnh.cao}")
	private String cao;
	@Value("${tuanAnh.nang}")
	private String nang;

	public static void main(String[] args) {
		SpringApplication.run(CauHinhCongApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Cau Hinh Cong";
	}

	@GetMapping("/infor")
	public String information(){
		return cao + " " + nang;
	}
}
