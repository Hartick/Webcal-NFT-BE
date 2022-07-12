package com.hartick.webcal.repository;

import com.hartick.webcal.entity.UserEntity;

public interface UserRepository {

    UserEntity getUserByAddress(String wallet);

    UserEntity save(UserEntity entity);
}
