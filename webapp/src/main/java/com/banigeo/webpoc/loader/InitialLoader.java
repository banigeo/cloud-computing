package com.banigeo.webpoc.loader;

import com.banigeo.webpoc.model.*;
import com.banigeo.webpoc.model.security.Authority;
import com.banigeo.webpoc.model.security.User;
import com.banigeo.webpoc.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class InitialLoader implements CommandLineRunner {

    AuthorityRepository authorityRepository;
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        //add security data
        Authority role_admin = Authority.builder().role("ROLE_ADMIN").build();
        Authority role_user = Authority.builder().role("ROLE_USER").build();
        authorityRepository.saveAll(Arrays.asList(role_admin, role_user));
        userRepository.saveAll(Arrays.asList(
                User.builder().username("user")
                        .password(passwordEncoder.encode("1234"))
                        .authoritiesList(role_user)
                        .build(),
                User.builder().username("admin")
                        .password(passwordEncoder.encode("4321"))
                        .authoritiesList(role_admin)
                        .build()));
    }
}
