package com.example.s0515;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Tạo bean thông qua java code
@Configuration // Muốn nó trả về cho mình 1 bean
public class Util {

    // Tưởng tượng Calculator là một thư viện có sẵn
    @Bean
    public Calculator getCalculator(){
        return new Calculator();
    }
}

// Vậy tại sao phải có bước tạo bean này
// Bởi vì mình giả sử thư viện Calculator ko phải của mình
// Lên mình ko thể @Component vào class của họ được để tạo bean đưa vào container
// Do vậy mình cần @Configuration và @Bean để tạo bean đưa vào container
