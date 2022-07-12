package com.hartick.webcal.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class UserEntity {

    @Id
    @Column(name = "walletAddress", nullable = false)
    private String walletAddress;

    @Column(name = "public_name", nullable = false, unique = true)
    private String publicName;

    @Column(name = "user_profile_image_url")
    private String userProfileImageUrl;

    @Column(name = "biography")
    private String biography;

}
