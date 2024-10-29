package com.testehospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.testehospede.entity.Hospede;

class HospedeTest {

	private Hospede hospede;

	@BeforeEach
	void setUp() {
		// Arrange
		hospede = new Hospede(1L, "Julia Maria", "julia@gmail.com", "(00) 0000-0000");
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		hospede.setId(2L);
		// Assert
		assertEquals(2L, hospede.getId());

	}

	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		// Act
		hospede.setNome("Joao Paulo");
		// Assert
		assertEquals("JoaPaulo", hospede.getNome());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo e-mail")
	void testEmail() {
		// Act
		hospede.setEmail("joao@gmail.com");
		// Assert
		assertEquals("joao@gmail.com", hospede.getEmail());

	}

	@Test
	@DisplayName("Testando o getter e setter do campo telefone")
	void testTelefone() {
		// Act
		hospede.setTelefone("(11) 1111-1111");
		// Assert
		assertEquals("(11) 1111-111", hospede.getTelefone());

	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos\"")
	void testConstructorAll() {
		// Act
		Hospede novoHospede = new Hospede(3L, "Matheus", "matheus@mail.com", "(15) 1111-1111");
		// Assertion
		assertAll("novohospede", () -> assertEquals(3L, novoHospede.getId()),
				() -> assertEquals("Matheus", novoHospede.getNome()),
				() -> assertEquals("matheus@gmail.com", novoHospede.getEmail()),
				() -> assertEquals("(15) 1111-1111", novoHospede.getTelefone()));
	}
}
