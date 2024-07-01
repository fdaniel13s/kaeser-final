package com.kaeser.platform.ucodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KaeserFinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaeserFinalApplication.class, args);
    }

}
