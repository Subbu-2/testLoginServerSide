package com.example.Test.controller;

import com.example.Test.model.Login;
import com.example.Test.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/saveLogin")
    public ResponseEntity<Login> saveLogin(@RequestBody Login login){
        return new ResponseEntity<Login>(loginService.saveLogin(login), HttpStatus.CREATED);
    }

    @GetMapping("/getLogins")
    public List<Login> getAllLogins(){
        return loginService.getAllLogins();
    }

    @GetMapping("/getbyId/{id}")
    public ResponseEntity<Login> getLoginById(@PathVariable("id") long loginId){
        return new ResponseEntity<Login>(loginService.getLoginById(loginId),HttpStatus.OK);
    }

    @GetMapping("/getbyUserName/{userName}")
    public ResponseEntity<Login> getbyUserName(@PathVariable("userName") String userName){
        return new ResponseEntity<Login>(loginService.getLoginByUserName(userName),HttpStatus.OK);
    }
    @GetMapping("/getbyUserEmail/{email}")
    public ResponseEntity<Login> getbyUserEmail(@PathVariable("email") String email){
        return new ResponseEntity<Login>(loginService.getbyUserEmail(email),HttpStatus.OK);
    }

    @PutMapping("/upddatebyId/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable("id") long loginId, @RequestBody Login login){
        return new ResponseEntity<Login>(loginService.updateLogin(login,loginId),HttpStatus.OK);
    }

    @DeleteMapping("/deleteLogin/{id}")
    public ResponseEntity<String> deleteLogin(@PathVariable("id") long loginId){
        loginService.deleteLogin(loginId);
        return new ResponseEntity<String>("Login deleleted successfully",HttpStatus.OK);
    }
}
