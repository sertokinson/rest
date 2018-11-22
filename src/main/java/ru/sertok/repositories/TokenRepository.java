package ru.sertok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sertok.models.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByValue(String value);
}
