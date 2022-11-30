package com.anton.stockexchanger.repository;

import com.anton.stockexchanger.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findByLogin(String login);
}
