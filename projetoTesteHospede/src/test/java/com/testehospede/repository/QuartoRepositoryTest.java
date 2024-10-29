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

import com.testehospede.entity.Quarto;

@DataJpaTest
class QuartoRepositoryTest {

	@Autowired
	private QuartoRepository quartoRepository;

	@DisplayName("Testando Save")
	@Test
	void testSalvarRepository() {
		Quarto Quarto1 = new Quarto(null, "2D", "15");

		Quarto saveQuarto = quartoRepository.save(Quarto1);

		assertNotNull(saveQuarto);
		assertTrue(saveQuarto.getId() > 0);
	}

	@DisplayName("Testando Get para todos Quartos")
	@Test
	void testGetAllRepository() {
		Quarto Quarto1 = new Quarto(null, "2D", "15");
		Quarto Quarto2 = new Quarto(null, "2D", "15");

		quartoRepository.save(Quarto1);
		quartoRepository.save(Quarto2);

		List<Quarto> QuartoList = quartoRepository.findAll();

		assertNotNull(QuartoList);
		assertEquals(2, QuartoList.size());
	}

	@DisplayName("Testando Get By Id")
	@Test
	void testGetById() {
		Quarto Quarto2 = new Quarto(null, "2D", "15");
		quartoRepository.save(Quarto2);
		Quarto saveQuarto = quartoRepository.findById(Quarto2.getId()).get();
		assertNotNull(saveQuarto);
		assertEquals(Quarto2.getId(), saveQuarto.getId());
	}

	@DisplayName("Testando o Update")
	@Test
	void TestUpdateQuarto() {
		Quarto Quarto1 = new Quarto(null, "2D", "15");
		quartoRepository.save(Quarto1);
		Quarto saveQuarto = quartoRepository.findById(Quarto1.getId()).get();
		Quarto1.setNum("15");
		Quarto1.setTipo("Master");
		Quarto updateQuarto = quartoRepository.save(saveQuarto);
		assertNotNull(updateQuarto);
		assertEquals("15", updateQuarto.getNum());
		assertEquals("Master", updateQuarto.getTipo());
	}

	@DisplayName("Testando o delete")
	@Test
	void TestDeleteQuarto() {
		Quarto Quarto1 = new Quarto(null, "2D", "15");
		
		quartoRepository.save(Quarto1);
		
		quartoRepository.deleteById(Quarto1.getId());
		
		Optional<Quarto> QuartoOptional = quartoRepository.findById(Quarto1.getId());
		assertTrue(QuartoOptional.isEmpty());
	}
}

