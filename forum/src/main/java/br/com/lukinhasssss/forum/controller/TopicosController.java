package br.com.lukinhasssss.forum.controller;

import br.com.lukinhasssss.forum.controller.form.TopicoForm;
import br.com.lukinhasssss.forum.dto.TopicoDto;
import br.com.lukinhasssss.forum.model.Topico;
import br.com.lukinhasssss.forum.repositories.CursoRepository;
import br.com.lukinhasssss.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Por padrão assume que all método terá o @ResponseBody
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> listar(String nomeCurso) {
        List<Topico> topicos;
        if (nomeCurso == null) {
            topicos = topicoRepository.findAll();
        } else {
            topicos = topicoRepository.findByCursoNome(nomeCurso);
        }
        return TopicoDto.converter(topicos);
    }

    @PostMapping
    public void cadastrar(@RequestBody TopicoForm form) { // @RequestBody pois os dados vem do corpo da requisição
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);
    }

}
