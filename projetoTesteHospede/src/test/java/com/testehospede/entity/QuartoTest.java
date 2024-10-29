package com.testehospede.entity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.testehospede.entity.Quarto;

class QuartoTest {

	private Quarto quarto;

	@BeforeEach
	void test() {
		// Arrange
		quarto = new Quarto(1L, "19", "suíte");
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		quarto.setId(2L);
		// Assert
		assertEquals(2L, quarto.getId());

	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo num")
	void testNum() {
		// Act
		quarto.setNum("25");
		// Assert
		assertEquals("25", quarto.getNum());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo tipo")
	void testTipo() {
		// Act
		quarto.setTipo("master");
		// Assert
		assertEquals("master", quarto.getTipo());

	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos\"")
	void testConstructorAll() {
		// Act
		Quarto novoQuarto = new Quarto(3L, "11", "familiar");
		// Assertion
		assertAll("novoquarto", () -> assertEquals(3L, novoQuarto.getId()),
				() -> assertEquals("11", novoQuarto.getNum()),
				() -> assertEquals("familiar", novoQuarto.getTipo()));
	
	
	
	
	}
	}


