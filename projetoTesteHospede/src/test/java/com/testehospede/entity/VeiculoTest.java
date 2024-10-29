package com.testehospede.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VeiculoTest {
	
	private Veiculo veiculo;
	
	@BeforeEach
	void setUp() {
		// Arrange
		veiculo = new Veiculo (1L, "Ford", "Fiesta", 2010, "prata");
	}
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		veiculo.setId(2L);
		// Assert
		assertEquals(2L, veiculo.getId());

	}
	@Test
	@DisplayName("Testando o getter e setter do campo marca")
	void testMarca() {
		// Act
		veiculo.setMarca("Joao Paulo");
		// Assert
		assertEquals("JoaPaulo", veiculo.getMarca());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo modelo")
	void testModelo() {
		// Act
		veiculo.setModelo("Voyage");
		// Assert
		assertEquals("Voyage", veiculo.getModelo());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo modelo")
	void testAno() {
		// Act
		veiculo.setAno(2019);
		// Assert
		assertEquals(2019, veiculo.getAno());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo cor")
	void testCor() {
		// Act
		veiculo.setCor("Cinza");
		// Assert
		assertEquals("Cinza", veiculo.getCor());
	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos\"")
	void testConstructorAll() {
		// Act
		Veiculo novoVeiculo = new Veiculo(3L, "Toyota", "Corolla", 2024, "preto");
		// Assertion
		assertAll("novoveiculo", () -> assertEquals(3L, novoVeiculo.getId()),
				() -> assertEquals("Toyota", novoVeiculo.getMarca()),
				() -> assertEquals("Corolla", novoVeiculo.getModelo()),
				() -> assertEquals(2024, novoVeiculo.getAno()),
				() -> assertEquals("preto", novoVeiculo.getCor()));
	}

}
