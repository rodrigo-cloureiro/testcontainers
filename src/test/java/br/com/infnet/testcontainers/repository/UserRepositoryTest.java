package br.com.infnet.testcontainers.repository;

import br.com.infnet.testcontainers.BaseRepositoryTest;
import br.com.infnet.testcontainers.domain.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private final String name = "Teste";
    private final LocalDate dateOfBirth = LocalDate.of(2001, 3, 28);
    private User user;

    @BeforeEach
    public void setUp() {
        this.user = new User(name, dateOfBirth);
    }

    @AfterEach
    public void tearDown() {
        if (this.user != null) this.user = null;
    }

    @Test
    public void shouldSave() {
        User saved = userRepository.save(this.user);
        assertNotNull(saved.getId());
    }

    @Test
    public void shouldFindUserByName() {
        userRepository.save(this.user);

        Optional<User> found = userRepository.findByName(name);
        assertTrue(found.isPresent());
        assertEquals(name, found.get().getName());
    }

    @Test
    public void shouldFindUserByDateOfBirth() {
        userRepository.save(this.user);

        List<User> found = userRepository.findByDateOfBirth(dateOfBirth);
        assertFalse(found.isEmpty());
    }
}
