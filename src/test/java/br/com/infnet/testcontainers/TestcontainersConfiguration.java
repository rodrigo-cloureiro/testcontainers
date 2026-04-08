package br.com.infnet.testcontainers;

import com.redis.testcontainers.RedisContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.postgresql.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false) // @Configuration no contexto de testes
public class TestcontainersConfiguration {

    @Bean // Cria um bean spring
    @ServiceConnection
        // substitui @DynamicPropertySource
        // Configura automaticamente a aplicação (injeta datasource url, username e password)
    PostgreSQLContainer postgresContainer() {
        // sobe um container docker usando a imagem postgres:latest
        return new PostgreSQLContainer(DockerImageName.parse("postgres:15-alpine"));
    }

    @Bean
    @ServiceConnection
    RedisContainer redisContainer() {
        return new RedisContainer(DockerImageName.parse("redis:8.6.2-alpine"));
    }

}
