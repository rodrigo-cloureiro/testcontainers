package br.com.infnet.testcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TestcontainersApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestcontainersApplication.class, args);
    }

}
