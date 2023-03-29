package com.example.Test.repository;

import com.example.Test.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUserName(String userName);
    Login findByEmail(String email);
}
