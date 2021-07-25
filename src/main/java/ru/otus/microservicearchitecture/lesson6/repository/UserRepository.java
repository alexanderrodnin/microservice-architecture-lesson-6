package ru.otus.microservicearchitecture.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.microservicearchitecture.lesson6.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> { }
