package com.ks.bestblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BestBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BestBlogApplication.class, args);
    }

}
