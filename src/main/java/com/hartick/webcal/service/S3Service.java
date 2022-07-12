package com.hartick.webcal.service;

import com.amazonaws.services.s3.AmazonS3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class S3Service {

    @Value("${app.s3.standbuyme.webcal.bucket")
    private String bucketName;

    @Value("${app.s3.standbuyme.endpoint")
    private String s3Endpoint;

    @Autowired
    private AmazonS3 amazonS3Client;





}
