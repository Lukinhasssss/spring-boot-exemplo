package br.com.lukinhasssss.forum.repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.lukinhasssss.forum.model.Curso;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class CursoRepositoryTest {
	
	@Autowired
	private CursoRepository repository;

	@Autowired
	private TestEntityManager em;

//	@Test
//	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
//		String nomeCurso = "HTML 5";
//
//		Curso curso = repository.findByNome(nomeCurso);
//
//		Assertions.assertNotNull(curso);
//		Assertions.assertEquals(nomeCurso, curso.getNome());
//	}

	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";

		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programação");
		em.persist(html5);

		Curso curso = repository.findByNome(nomeCurso);

		Assertions.assertNotNull(curso);
		Assertions.assertEquals(nomeCurso, curso.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";
		
		Curso curso = repository.findByNome(nomeCurso);
		
		Assertions.assertNull(curso);
	}

}
