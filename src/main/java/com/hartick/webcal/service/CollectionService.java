package com.hartick.webcal.service;

import com.hartick.webcal.entity.CollectionEntity;
import com.hartick.webcal.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    public CollectionEntity getCollectionEntityByPublicName(String name) {
        return collectionRepository.getCollectionEntityByPublicName(name);
    }
}
