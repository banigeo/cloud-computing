package com.banigeo.webpoc.repository;

import com.banigeo.webpoc.model.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
