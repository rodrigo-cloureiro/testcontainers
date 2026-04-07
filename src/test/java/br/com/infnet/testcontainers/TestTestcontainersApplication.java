package br.com.infnet.testcontainers;

import org.springframework.boot.SpringApplication;

public class TestTestcontainersApplication {

    // Reutiliza a aplicação principal adicionando os containers
    public static void main(String[] args) {
        SpringApplication.from(TestcontainersApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
