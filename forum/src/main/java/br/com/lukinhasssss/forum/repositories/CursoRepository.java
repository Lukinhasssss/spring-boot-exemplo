package br.com.lukinhasssss.forum.repositories;

import br.com.lukinhasssss.forum.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    Curso findByNome(String nome);

}
