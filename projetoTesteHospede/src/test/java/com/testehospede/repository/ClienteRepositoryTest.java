package com.testehospede.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.testehospede.entity.Cliente;

class ClienteRepositoryTest {

	@Autowired
	private ClienteRepository ClienteRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		//Given / Arrange
		Cliente Cliente1 = new Cliente (null, "Otávio",
											"15996373766",
	                                        "46302556805",
	                                        "571649105");
		//When /Act
		Cliente saveCliente = ClienteRepository.save(Cliente1);
		
		//Then /Assert
		assertNotNull(saveCliente);
		assertTrue(saveCliente.getId() > 0);
	}
	
	@DisplayName("Testando Get para todos Clientes")
	@Test
	void testGetAllRepository() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Julia Maria",
				"julia@gmail.com",
				"(00)0000-0000",
				"46302556805");
		
		Cliente Cliente2 = new Cliente(null, "Julio Fernando",
				"julio@gmail.com",
				"(00)0000-0000",
				"46302556805");
		
		ClienteRepository.save(Cliente1);
		ClienteRepository.save(Cliente2);
		
		List<Cliente> ClienteList = ClienteRepository.findAll();
		
		assertNotNull(ClienteList);
		assertEquals(2, ClienteList.size());
	}
	@DisplayName("Testando Get por ID")
	@Test
	void testGetById() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Julio Fernando",
				"julio@gmail.com",
				"(00)0000-0000",
				"46302556805");
		
		ClienteRepository.save(Cliente1);
		
		//When / Act
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		
		//Then / Assert
		assertNotNull(saveCliente);
		assertEquals(Cliente1.getId(), saveCliente.getId());
		
	}
	@DisplayName("Testando Update")
	@Test
	void testUpdateCliente() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Julio Fernando",
				"julio@gmail.com",
				"(00)0000-0000",
				"46302556805");
		
		ClienteRepository.save(Cliente1);
		
		//When /Act
		
		Cliente saveCliente = ClienteRepository.findById(Cliente1.getId()).get();
		Cliente1.setNome("Leonardo");
		Cliente1.setTelefone("leonardo@gmail.com");
		
		Cliente updateCliente = ClienteRepository.save(saveCliente);
		
		//Then / Assert
		assertNotNull(updateCliente);
		assertEquals("Leonardo", updateCliente.getNome());
		assertEquals("leonardo@gmail.com", updateCliente.getTelefone());
	}
	@DisplayName("Testando Update")
	@Test
	void testDeleteCliente() {
		
		//Given / Arrange
		
		Cliente Cliente1 = new Cliente(null, "Julio Fernando",
				"julio@gmail.com",
				"(00)0000-0000",
				"46302556805");
		
		ClienteRepository.save(Cliente1);
		
		//When /Act
		ClienteRepository.deleteById(Cliente1.getId());
		
		Optional<Cliente> ClienteOptional = ClienteRepository.findById(Cliente1.getId());
		
		//Then /Assert
		
		assertTrue(ClienteOptional.isEmpty());
	}
}