package com.banigeo.webpoc.repository;

import com.banigeo.webpoc.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
