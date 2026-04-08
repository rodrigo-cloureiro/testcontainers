package br.com.infnet.testcontainers.service;

import br.com.infnet.testcontainers.domain.User;
import br.com.infnet.testcontainers.dto.UserCreateRequest;
import br.com.infnet.testcontainers.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Cacheable(
            cacheNames = "listUsers",
            key = "'allUsers'"
    )
    public List<User> list() throws InterruptedException {
        Thread.sleep(5_000);
        return userRepository.findAll();
    }

    @Transactional(readOnly = false)
    public User save(UserCreateRequest request) {
        User user = new User(request.name(), request.dateOfBirth());

        return userRepository.save(user);
    }
}
