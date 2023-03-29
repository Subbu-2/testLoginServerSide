package com.example.Test.service;

import com.example.Test.model.Login;

import java.util.List;

public interface LoginService {
    Login saveLogin(Login login);
    List<Login> getAllLogins();
    Login getLoginById(long id);
    Login getLoginByUserName(String userName);
    Login getbyUserEmail(String email);
    Login updateLogin(Login login,long id);
    void deleteLogin(long id);
}
