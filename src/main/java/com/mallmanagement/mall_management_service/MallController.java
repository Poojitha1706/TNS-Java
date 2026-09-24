package com.mallmanagement.mall_management_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * MallController.java
 * Exposes the mall CRUD operations as HTTP endpoints under /malls,
 * reachable from Postman once the app is running on localhost:8080.
 */
@RestController
@RequestMapping("/malls")
public class MallController {

    @Autowired
    private MallService mallService;

    // CREATE  ->  POST /malls
    @PostMapping
    public ResponseEntity<Mall> addMall(@RequestBody Mall mall) {
        Mall saved = mallService.addMall(mall);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // READ all  ->  GET /malls
    @GetMapping
    public ResponseEntity<List<Mall>> getAllMalls() {
        return ResponseEntity.ok(mallService.getAllMalls());
    }

    // READ one  ->  GET /malls/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Mall> getMallById(@PathVariable int id) {
        Optional<Mall> mall = mallService.getMallById(id);
        return mall.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE  ->  PUT /malls/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Mall> updateMall(@PathVariable int id, @RequestBody Mall mall) {
        if (mallService.getMallById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mallService.updateMall(id, mall));
    }

    // DELETE  ->  DELETE /malls/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMall(@PathVariable int id) {
        boolean deleted = mallService.deleteMall(id);
        return deleted ? ResponseEntity.noContent().build()
                        : ResponseEntity.notFound().build();
    }
}