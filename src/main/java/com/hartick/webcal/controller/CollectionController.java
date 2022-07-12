package com.hartick.webcal.controller;

import com.hartick.webcal.entity.CollectionEntity;
import com.hartick.webcal.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CollectionController {


    @Autowired
    private CollectionService collectionService;

    @GetMapping(value = "/collection/{name}")
    public ResponseEntity<CollectionEntity> getCollectionEntity(@PathVariable("id") String publicName) {
        CollectionEntity collectionEntity = collectionService.getCollectionEntityByPublicName(publicName);
        return new ResponseEntity<>(collectionEntity, HttpStatus.OK);
    }
}
