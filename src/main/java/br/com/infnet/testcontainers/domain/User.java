package br.com.infnet.testcontainers.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 120, nullable = false)
    private String name;

    @PastOrPresent(message = "A data não pode ser no futuro")
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    protected User() {
    }

    public User(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Transient
    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
