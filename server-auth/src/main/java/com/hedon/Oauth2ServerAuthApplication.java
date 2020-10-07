package com.hedon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Hedon Wang
 * @create 2020-10-05 16:32
 */
@SpringBootApplication
public class Oauth2ServerAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerAuthApplication.class,args);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
