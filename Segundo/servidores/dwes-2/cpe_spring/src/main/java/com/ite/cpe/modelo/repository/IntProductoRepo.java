package com.ite.cpe.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.cpe.modelo.beans.Producto;

public interface IntProductoRepo extends JpaRepository<Producto, Integer> {

}
