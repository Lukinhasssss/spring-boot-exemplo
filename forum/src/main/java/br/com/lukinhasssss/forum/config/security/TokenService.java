package br.com.lukinhasssss.forum.config.security;

import br.com.lukinhasssss.forum.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.secret}")
    private String secret;

    @Value("${forum.jwt.expiration}")
    private String expiration;

    public String gerarToken(Authentication authentication) {
        Usuario usuarioLogado = (Usuario) authentication.getPrincipal();// getPrincipal retorna qual é o usuário que está logado
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
            .setIssuer("API do Fórum")
            .setSubject(usuarioLogado.getId().toString()) // Quem é o dono do token
            .setIssuedAt(hoje)
            .setExpiration(dataExpiracao)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject()); // Para recuperar o Id do usuário que está setado dentro do token
    }
}
