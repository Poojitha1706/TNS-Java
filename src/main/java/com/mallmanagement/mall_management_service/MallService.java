package com.mallmanagement.mall_management_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * MallService.java
 * Business logic layer. Delegates actual database work to MallRepository
 * instead of writing JDBC by hand.
 */
@Service
public class MallService {

    @Autowired
    private MallRepository mallRepository;

    // CREATE
    public Mall addMall(Mall mall) {
        return mallRepository.save(mall);
    }

    // READ - all
    public List<Mall> getAllMalls() {
        return mallRepository.findAll();
    }

    // READ - by id
    public Optional<Mall> getMallById(int id) {
        return mallRepository.findById(id);
    }

    // UPDATE
    public Mall updateMall(int id, Mall updatedMall) {
        updatedMall.setMallId(id);
        return mallRepository.save(updatedMall);
    }

    // DELETE
    public boolean deleteMall(int id) {
        if (!mallRepository.existsById(id)) {
            return false;
        }
        mallRepository.deleteById(id);
        return true;
    }
}