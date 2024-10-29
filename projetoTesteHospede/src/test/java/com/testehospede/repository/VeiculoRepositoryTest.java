package com.testehospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.testehospede.entity.Veiculo;

@DataJpaTest
class VeiculoRepositoryTest {
	
	
	@Autowired
	private VeiculoRepository VeiculoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		//Given / Arrange
		Veiculo Veiculo1 = new Veiculo (null, "Giovana","15996373766",1,"571649105");
		//When /Act
		Veiculo saveVeiculo = VeiculoRepository.save(Veiculo1);
		
		//Then /Assert
		assertNotNull(saveVeiculo);
		assertTrue(saveVeiculo.getId() > 0);
	}
	
	@DisplayName("Testando Get para todos Veiculos")
	@Test
	void testGetAllRepository() {
		
		//Given / Arrange
		Veiculo Veiculo1 = new Veiculo(null, "Julia Maria","julia@gmail.com",1,"46302556805");
		Veiculo Veiculo2 = new Veiculo(null, "Julio Fernando","julio@gmail.com",1,"46302556805");
		
		VeiculoRepository.save(Veiculo1);
		VeiculoRepository.save(Veiculo2);
		
		List<Veiculo> VeiculoList = VeiculoRepository.findAll();
		
		assertNotNull(VeiculoList);
		assertEquals(2, VeiculoList.size());
	}
	@DisplayName("Testando Get por ID")
	@Test
	void testGetById() {
		
		//Given / Arrange
		
		Veiculo Veiculo1 = new Veiculo(null, "Julio Fernando",
				"julio@gmail.com",
				1,
				"46302556805");
		
		VeiculoRepository.save(Veiculo1);
		
		//When / Act
		Veiculo saveVeiculo = VeiculoRepository.findById(Veiculo1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveVeiculo);
		assertEquals(Veiculo1.getId(), saveVeiculo.getId());
		
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateVeiculo() {
		
		//Given / Arrange
		
		Veiculo Veiculo1 = new Veiculo(null, "Julio Fernando",
				"julio@gmail.com",
				1,
				"46302556805");
		
		VeiculoRepository.save(Veiculo1);
		
		//When /Act
		
		Veiculo saveVeiculo = VeiculoRepository.findById(Veiculo1.getId()).get();
		Veiculo1.setMarca("Leonardo");
		Veiculo1.setModelo("leonardo@gmail.com");
		
		Veiculo updateVeiculo = VeiculoRepository.save(saveVeiculo);
		
		//Then / Assert
		assertNotNull(updateVeiculo);
		assertEquals("Leonardo", updateVeiculo.getMarca());
		assertEquals("leonardo@gmail.com", updateVeiculo.getModelo());
	}
	@DisplayName("Testando Update")
	@Test
	void testDeleteVeiculo() {
		
		//Given / Arrange
		
		Veiculo Veiculo1 = new Veiculo(null, "Julio Fernando",
				"julio@gmail.com",
				1,
				"46302556805");
		
		VeiculoRepository.save(Veiculo1);
		
		//When /Act
		VeiculoRepository.deleteById(Veiculo1.getId());
		
		Optional<Veiculo> VeiculoOptional = VeiculoRepository.findById(Veiculo1.getId());
		
		//Then /Assert
		
		assertTrue(VeiculoOptional.isEmpty());
	}
}