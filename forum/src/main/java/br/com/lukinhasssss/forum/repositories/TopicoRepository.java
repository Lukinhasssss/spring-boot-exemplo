package br.com.lukinhasssss.forum.repositories;

import br.com.lukinhasssss.forum.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
