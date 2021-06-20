package br.com.lukinhasssss.forum.controller;

import br.com.lukinhasssss.forum.dto.TopicoDto;
import br.com.lukinhasssss.forum.model.Curso;
import br.com.lukinhasssss.forum.model.Topico;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController // Por padrão assume que all método terá o @ResponseBody
@RequestMapping("/topicos")
public class TopicosController {

    @GetMapping
    public List<TopicoDto> lista() {
        Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));

        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }

}
