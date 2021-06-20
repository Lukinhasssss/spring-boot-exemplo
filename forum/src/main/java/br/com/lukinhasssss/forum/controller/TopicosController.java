package br.com.lukinhasssss.forum.controller;

import br.com.lukinhasssss.forum.dto.TopicoDto;
import br.com.lukinhasssss.forum.model.Topico;
import br.com.lukinhasssss.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Por padrão assume que all método terá o @ResponseBody
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository repository;

    @GetMapping
    public List<TopicoDto> lista() {
        List<Topico> topicos = repository.findAll();
        return TopicoDto.converter(topicos);
    }

}
