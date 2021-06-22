package br.com.lukinhasssss.forum.config.swagger;

import br.com.lukinhasssss.forum.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket forumApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("br.com.lukinhasssss.forum"))
            .paths(PathSelectors.ant("/**"))
            .build()
            .ignoredParameterTypes(Usuario.class);
    }

}
