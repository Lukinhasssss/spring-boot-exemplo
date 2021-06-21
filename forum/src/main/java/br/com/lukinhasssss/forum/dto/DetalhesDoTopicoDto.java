package br.com.lukinhasssss.forum.dto;

import br.com.lukinhasssss.forum.model.StatusTopico;
import br.com.lukinhasssss.forum.model.Topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DetalhesDoTopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico status;
    private List<RespostaDto> respostas;

    public DetalhesDoTopicoDto(Topico topico) {
        id = topico.getId();
        titulo = topico.getTitulo();
        mensagem = topico.getMensagem();
        dataCriacao = topico.getDataCriacao();
        nomeAutor = topico.getAutor().getNome();
        status = topico.getStatus();
        respostas = new ArrayList<>();
//        respostas.addAll(topico.getRespostas().stream().map(resposta -> new RespostaDto(resposta)).collect(Collectors.toList()));
        respostas.addAll(topico.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public List<RespostaDto> getRespostas() {
        return respostas;
    }
}
