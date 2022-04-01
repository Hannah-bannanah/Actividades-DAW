package com.ite.cajero_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.cajero_rest.model.beans.Cuenta;

public interface IntCuentaRepo extends JpaRepository<Cuenta, Integer>{

}
