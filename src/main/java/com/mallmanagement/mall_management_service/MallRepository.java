package com.mallmanagement.mall_management_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MallRepository.java
 * Extending JpaRepository<Mall, Integer> gives us save(), findAll(),
 * findById(), deleteById(), existsById() for free — no SQL written by hand.
 */
@Repository
public interface MallRepository extends JpaRepository<Mall, Integer> {
}