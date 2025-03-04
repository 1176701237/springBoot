package com.example.webapp;

import com.example.cordemo.model.model.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WebAppApplicationTests {

    @Test
    void contextLoads() {
        Admin admin = new Admin();
        admin.setUsername("admin");
        System.out.println(admin.getUsername());
    }

}
