package dev.syntax.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Authority extends JpaRepository<dev.syntax.security.entity.Authority, Long> {
}
