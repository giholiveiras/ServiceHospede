package com.testehospede.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {
	private Produto produto;
	
	@BeforeEach
	void setUp() {
		// Arrange
		produto = new Produto(1L, "Giovana", 28.90);
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		produto.setId(2L);
		// Assert
		assertEquals(2L, produto.getId());

	}
	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		// Act
		produto.setNome("Lucas");
		// Assert
		assertEquals("Lucas", produto.getNome());
	}
	@Test
	@DisplayName("Testando o getter e setter do campo preço")
	void testPreco() {
		// Act
		produto.setPreco(30.00);
		// Assert
		assertEquals(30.00, produto.getPreco());

	}
	@Test
	@DisplayName("Testando o construtor com todos os argumentos\"")
	void testConstructorAll() {
		// Act
		Produto novoProduto = new Produto(3L, "Gabriela", 32.00 );
		// Assertion
		assertAll("novoproduto", () -> assertEquals(3L, novoProduto.getId()),
				() -> assertEquals("Matheus", novoProduto.getNome()),
				() -> assertEquals("matheus@gmail.com", novoProduto.getPreco()));
	}
}
