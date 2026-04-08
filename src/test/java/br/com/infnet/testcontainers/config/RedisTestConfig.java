package br.com.infnet.testcontainers.config;

import com.redis.testcontainers.RedisContainer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@TestConfiguration
public class RedisTestConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(RedisContainer redisContainer) {
        redisContainer.start();

        return new LettuceConnectionFactory(
                redisContainer.getHost(),
                redisContainer.getFirstMappedPort()
        );
    }
}
