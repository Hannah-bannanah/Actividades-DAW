package com.ite.cpe.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.cpe.modelo.beans.Cliente;

public interface IntClienteRepo extends JpaRepository<Cliente, String>{

}
