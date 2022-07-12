package com.hartick.webcal.repository.impl;

import com.hartick.webcal.entity.UserEntity;
import com.hartick.webcal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Slf4j
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public UserEntity getUserByAddress(String wallet) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);
        try {
            return em.createQuery(criteria.where(criteriaBuilder.equal(root.get("walletAddress"), wallet))).getSingleResult();
        } catch (NoResultException e) {
            log.info("User with wallet not found", e);
            return null;
        }
    }

    @Override
    @Transactional
    public UserEntity save(UserEntity entity) {
        if(em.find(UserEntity.class, entity.getWalletAddress()) == null) {
            em.persist(entity);
        } else {
            em.merge(entity);
        }
        return entity;
    }
}
