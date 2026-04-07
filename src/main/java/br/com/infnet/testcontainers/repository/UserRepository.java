package br.com.infnet.testcontainers.repository;

import br.com.infnet.testcontainers.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String name);

    List<User> findByDateOfBirth(LocalDate dateOfBirth);
}
