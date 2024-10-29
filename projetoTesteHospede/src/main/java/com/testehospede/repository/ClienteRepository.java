package com.testehospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testehospede.entity.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{

}
