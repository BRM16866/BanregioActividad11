package com.example.actividad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.actividad.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
