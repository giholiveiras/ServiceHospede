package com.testehospede.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.testehospede.entity.Hospede;
import com.testehospede.repository.HospedeRepository;

class HospedeServiceTest {
	
	@Autowired
	private HospedeService hospedeService;
	
	@Autowired
	private HospedeRepository hospedeRepository;
	
	@BeforeEach
	void setUp() {
		hospedeRepository.deleteAll(); // Limpa o banco de dados antes de cada teste
	}
	
	@DisplayName("Testando salvar Hóspede")
	@Test
	void testSalvarHospede() {
		Hospede hospede = new Hospede (null, "Julia Maria", "@julia@gmail.com", "(00)0000-0000");
		
		Hospede resultado = hospedeService.salvarHospede(hospede);
		
		assertNotNull(resultado);
		assertEquals("Julia Maria", resultado.getNome());
		assertTrue(resultado.getId() > 0);
	}
	@DisplayName("Testando listar todos os Hóspede")
	@Test
	void testListarTodos() {
		
		Hospede hospede1 = new Hospede (null, "Julia Maria", "@julia@gmail.com", "(00)0000-0000");
		Hospede hospede2 = new Hospede (null, "Luiz Fernando", "@julia@gmail.com", "(00)0000-0000");
		
		hospedeService.salvarHospede(hospede1);
		hospedeService.salvarHospede(hospede2); 
		List<Hospede> resultado = hospedeService.ListarTodos();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
		
	}


@DisplayName("Testando hóspede por ID")
@Test
void testBuscarPorid() {
	
	Hospede hospede = new Hospede (null, "Julia Maria", "@julia@gmail.com", "(00)0000-0000");
	
	Hospede salvo = hospedeService.salvarHospede(hospede);
	Optional <Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
	
	assertTrue(resultado.isPresent());
	assertEquals("Julia Maria", resultado.get().getNome());
}
@DisplayName("Testando atualizar hóspede ")
@Test
void testAtualizarHospede() {
	
	Hospede hospede = new Hospede (null, "Julia Maria", "@julia@gmail.com", "(00)0000-0000");
	Hospede salvo = hospedeService.salvarHospede(hospede);
	
	salvo.setNome("Leonardo");
	salvo.setEmail("leonardo@gmail.com");

	Hospede atualizado = hospedeService.atualizarHospede(salvo);
	
	assertNotNull(atualizado);
	assertEquals("Leonardo", atualizado.getNome());
	assertEquals("leonardo@gmail.com", atualizado.getEmail());
}
@DisplayName("Testando deletar Hóspede ")
@Test
void testDeletarHospede() {
	;
	Hospede hospede = new Hospede (null, "Julia Maria", "@julia@gmail.com", "(00)0000-0000");
	
	Hospede salvo = hospedeService.salvarHospede(hospede);
	hospedeService.deletarHospede(salvo.getId());
	
	Optional<Hospede> resultado = hospedeService.buscarPorId(salvo.getId());
	
	assertTrue(resultado.isEmpty());

}
}

