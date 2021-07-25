package ru.otus.microservicearchitecture.lesson6.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.otus.microservicearchitecture.lesson6.entity.Entities;
import ru.otus.microservicearchitecture.lesson6.repository.Repositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = {Repositories.class})
@EntityScan(basePackageClasses = Entities.class)
public class JpaConfig { }
