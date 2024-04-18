package com.linus.api.common.component;

import com.linus.api.user.model.UserDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Log4j2
@Component
public class JwtProvider {
  @Value("${jwt.iss}")
  private String issuer;

  @Value("${jwt.exp}")
  private Long expiration;

  private final SecretKey secretKey;

  Instant expiredDate = Instant.now().plus(1, ChronoUnit.DAYS);

  public JwtProvider(@Value("${jwt.secret}") String secretKey) {
    this.secretKey = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
  }

  public String createToken(UserDTO dto) {
    String token = Jwts.builder()
            .issuer(issuer)
            .signWith(secretKey)
            .expiration(Date.from(expiredDate))
            .subject("user Auth")
            .claim("username", dto.getUsername())
            .claim("job", dto.getJob())
            .claim("userId", dto.getId())
            .compact();
    log.info("로그인성공으로 발급된 토큰 : " + token);
    return token;
  }
}
