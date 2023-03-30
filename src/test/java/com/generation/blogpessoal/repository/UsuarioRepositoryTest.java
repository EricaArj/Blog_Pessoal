package com.generation.blogpessoal.repository;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogpessoal.model.Usuario;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.deleteAll();
		usuarioRepository.save(new Usuario(0L, "João da silva","joão@email.com.br", "12345678","https://th.bing.com/th/id/R.d4118afa404426447027f70cd4911d56?rik=PMDvdZl93NsoSw&pid=ImgRaw&r=0"));
		usuarioRepository.save(new Usuario(0L, "Maria da silva","maria@email.com.br", "12345678","https://curiosidadescuriosas.com/wp-content/uploads/2012/12/Fotografia-de-Paisaje-Natural-10.jpg"));
		usuarioRepository.save(new Usuario(0L, "Anna da silva","anna@email.com.br", "12345678","https://th.bing.com/th/id/OIP.lywnb4QeupFAlIt1p_QHVQHaEo?pid=ImgDet&rs=1"));
		usuarioRepository.save(new Usuario(0L, "Erica silva","erica@email.com.br", "12345678","https://th.bing.com/th/id/OIP.yfnjgVDJPCR8caV7Bz1AdQHaEo?pid=ImgDet&w=474&h=296&rs=1"));
	
	}
		
		@Test
		@DisplayName("Retorna 1 usuario")
		public void deveRetornarUmUsuario() {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joão@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("joão@email.com.br"));
		
	}
		@Test
		@DisplayName("Retorna 4 usuario")
		public void deveRetornarTresUsuarios() {
			
			List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("silva");
		assertEquals(4, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Maria da silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Anna da silva"));
		assertTrue(listaDeUsuarios.get(3).getNome().equals("Erica silva"));
		
		}
		
		@AfterAll
		public void end() {
			
			usuarioRepository.deleteAll();
		}
		
		

}
