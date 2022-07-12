package com.hartick.webcal.repository;

import com.hartick.webcal.entity.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity, Integer> {

    @Query("SELECT collection FROM CollectionEntity collection WHERE collection.publicName = :public_name")
    CollectionEntity getCollectionEntityByPublicName(@Param("public_name") String publicName);
}
