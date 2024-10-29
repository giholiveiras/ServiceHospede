package com.testehospede.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testehospede.entity.Veiculo;

public interface VeiculoRepository extends JpaRepository <Veiculo, Long> {

}
