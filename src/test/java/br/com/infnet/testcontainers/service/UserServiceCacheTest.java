package br.com.infnet.testcontainers.service;

import br.com.infnet.testcontainers.TestcontainersConfiguration;
import br.com.infnet.testcontainers.config.RedisCacheConfig;
import br.com.infnet.testcontainers.config.RedisTestConfig;
import br.com.infnet.testcontainers.domain.User;
import br.com.infnet.testcontainers.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringJUnitConfig(classes = {
        RedisTestConfig.class,
        RedisCacheConfig.class,
        UserService.class,
        TestcontainersConfiguration.class
})
@EnableCaching
@ActiveProfiles(value = "test")
public class UserServiceCacheTest {

    @Autowired
    private UserService userService;
    @Autowired
    private CacheManager cacheManager;

    @MockitoBean
    private UserRepository userRepository;

    @Test
    public void mustUseCache() throws InterruptedException {
        when(userRepository.findAll())
                .thenReturn(List.of());

        List<User> result1 = userService.list();
        List<User> result2 = userService.list();
        List<User> result3 = userService.list();

        verify(userRepository, times(1))
                .findAll();
        verifyNoMoreInteractions(userRepository);
        assertEquals(result1, result2);
        assertEquals(result1, result3);
        assertThat(cacheManager).isInstanceOf(RedisCacheManager.class);
    }
}
