package br.com.lukinhasssss.forum.repositories;

import br.com.lukinhasssss.forum.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

    @Query("SELECT t FROM Topico t where t.curso.nome = :nomeCurso")
    List<Topico> buscarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso); // Não é mais necessário o uso do @Param

}
