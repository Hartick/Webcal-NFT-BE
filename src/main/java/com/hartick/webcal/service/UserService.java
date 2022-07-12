package com.hartick.webcal.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.hartick.webcal.entity.UserEntity;
import com.hartick.webcal.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    AmazonS3 s3Client;

    public UserEntity getUserByWallet(String wallet) {
        return userRepository.getUserByAddress(wallet);
    }

    public UserEntity saveUser(UserEntity entity) {
        userRepository.save(entity);
        return entity;
    }
}
