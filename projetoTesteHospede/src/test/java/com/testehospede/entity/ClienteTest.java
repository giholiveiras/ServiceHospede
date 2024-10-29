package com.testehospede.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClienteTest {
	
	private Cliente cliente;
	@BeforeEach
	void setUp() {
		// Arrange
		 cliente = new Cliente(1L, "Márcia", "(15)99128-4382", "28358847845", "0000000");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		cliente.setId(2L);
		// Assert
		assertEquals(2L, cliente.getId());

	}
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		// Act
		cliente.setNome("Marcelo");
		// Assert
		assertEquals("Marcelo", cliente.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		// Act
		cliente.setTelefone("15991284382");
		// Assert
		assertEquals("15991284382", cliente.getTelefone());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo cpf")
	void testCpf() {
		// Act
		cliente.setCpf("53335579852");
		// Assert
		assertEquals("53335579852", cliente.getCpf());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo rg")
	void testRg() {
		// Act
		cliente.setRg("0000000");
		// Assert
		assertEquals("00000000", cliente.getRg());
	}
	}

