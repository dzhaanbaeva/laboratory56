package com.attractor.laboratory56.repository;

import com.attractor.laboratory56.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String s);
    Optional<User> findByEmail(String email);
}
