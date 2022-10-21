package com.usercrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class UserCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCrudApplication.class, args);
    }

}
