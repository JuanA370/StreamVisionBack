package com.example.demo.model.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entities.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Integer> {

}
