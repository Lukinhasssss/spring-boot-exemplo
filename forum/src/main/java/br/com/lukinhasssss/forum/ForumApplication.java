package br.com.lukinhasssss.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport // Habilita o suporte para o Spring pegar da requisição dos parâmetros da URL os campos, informações de url (paginacao/ordenacao) e repassar isso para o Spring Data
@EnableCaching // Habilita o uso de cache na aplicação
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
