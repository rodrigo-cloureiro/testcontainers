package br.com.infnet.testcontainers.repository;

import br.com.infnet.testcontainers.BaseRepositoryTest;
import br.com.infnet.testcontainers.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveAndFindUser() {
        User user = new User("Teste");

        User saved = userRepository.save(user);
        assertNotNull(saved.getId());

        Optional<User> found = userRepository.findByName("Teste");
        assertTrue(found.isPresent());
        assertEquals("Teste", found.get().getName());
    }
}
