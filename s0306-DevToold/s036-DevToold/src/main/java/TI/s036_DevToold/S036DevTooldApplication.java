package TI.s036_DevToold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class S036DevTooldApplication {

	public static void main(String[] args) {
		SpringApplication.run(S036DevTooldApplication.class, args);
	}

	@GetMapping("/")
	public String HelloWorld() {
		return "Hello World! 222";
	}

	@GetMapping("/h2")
	public String HelloWorld2() {
		return "Hello World! lần 22222";
	}
}
