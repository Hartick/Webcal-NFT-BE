package com.hartick.webcal.controller;

import com.hartick.webcal.entity.UserEntity;
import com.hartick.webcal.repository.UserRepository;
import com.hartick.webcal.repository.impl.UserRepositoryImpl;
import com.hartick.webcal.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<UserEntity> getUser(@PathVariable("id") String walletUser) {
        UserEntity user = userService.getUserByWallet(walletUser);
        if(user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/user")
    public ResponseEntity<UserEntity> updateUser(@Valid @RequestBody UserEntity entity ) {
        userService.saveUser(entity);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
}
