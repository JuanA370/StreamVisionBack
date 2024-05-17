package com.example.demo.model.persist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
