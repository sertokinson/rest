package ru.sertok.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sertok.models.Token;

public interface TokenRepository extends JpaRepository<Token,Long> {
}
