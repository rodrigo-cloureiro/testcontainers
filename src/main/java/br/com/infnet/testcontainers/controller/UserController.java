package br.com.infnet.testcontainers.controller;

import br.com.infnet.testcontainers.domain.User;
import br.com.infnet.testcontainers.dto.UserCreateRequest;
import br.com.infnet.testcontainers.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "")
    public List<User> listAll() throws InterruptedException {
        return userService.list();
    }

    @PostMapping(value = "")
    public User create(@Valid @RequestBody UserCreateRequest request) {
        return userService.save(request);
    }
}
