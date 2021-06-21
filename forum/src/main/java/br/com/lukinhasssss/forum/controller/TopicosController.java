package br.com.lukinhasssss.forum.controller;

import br.com.lukinhasssss.forum.controller.form.TopicoForm;
import br.com.lukinhasssss.forum.dto.DetalhesDoTopicoDto;
import br.com.lukinhasssss.forum.dto.TopicoDto;
import br.com.lukinhasssss.forum.model.Topico;
import br.com.lukinhasssss.forum.repositories.CursoRepository;
import br.com.lukinhasssss.forum.repositories.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) { // @RequestBody pois os dados vem do corpo da requisição
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping("/{id}")
    public DetalhesDoTopicoDto detalhar(@PathVariable Long id) {
        Topico topico = topicoRepository.getById(id);
        return new DetalhesDoTopicoDto(topico);
    }

}
