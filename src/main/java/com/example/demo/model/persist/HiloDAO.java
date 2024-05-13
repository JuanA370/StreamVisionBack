package com.example.demo.model.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Hilo;

@Repository
public interface HiloDAO extends JpaRepository<Hilo, Integer>{

}
