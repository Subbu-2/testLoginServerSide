package com.example.Test.service.impl;

import com.example.Test.exception.ResourceNotFound;
import com.example.Test.model.Login;
import com.example.Test.repository.LoginRepository;
import com.example.Test.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository;

    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login saveLogin(Login login){
        return loginRepository.save(login);
    }

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    @Override
    public Login getLoginById(long id) {
//        Optional<Login> login =  loginRepository.findById(id);
//        if(login.isPresent()){
//            return login.get();
//        }
//        else {
//            throw new ResourceNotFound("Login","Id",id);
//        }
        return loginRepository.findById(id).orElseThrow( () -> new ResourceNotFound("Login","Id",id));
    }

    @Override
    public Login getLoginByUserName(String userName) {
        Login existingLogin = loginRepository.findByUserName(userName);
        if(existingLogin == null){
            throw new ResourceNotFound("Login Details","UserName",userName);
        }
        else{
            return existingLogin;
        }
    }

    @Override
    public Login getbyUserEmail(String email) {
        return loginRepository.findByEmail(email);
    }

    @Override
    public Login updateLogin(Login login, long id) {
        Login existingLogin = loginRepository.findById(id).orElseThrow( ()-> new ResourceNotFound("Login","id",id));
        existingLogin.setUserName(login.getUserName());
        existingLogin.setPassword(login.getPassword());
        existingLogin.setEmail(login.getEmail());
        loginRepository.save(existingLogin);
        return existingLogin;
    }

    @Override
    public void deleteLogin(long id) {
        loginRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Login","id",id));
        loginRepository.deleteById(id);
    }

}
