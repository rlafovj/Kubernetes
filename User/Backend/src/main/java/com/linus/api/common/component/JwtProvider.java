package com.linus.api.common.component;

import com.linus.api.user.model.User;
import com.linus.api.user.model.UserDTO;
import com.linus.api.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Stream;

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

  public String extractTokenFromHeader(HttpServletRequest request) {
    String bearerToken = request.getHeader("Authorization");
    if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
      return bearerToken.substring(7);
    }else {return "undefined token";}
  }

  public void printPayload(String AccessToken) {
    Base64.Decoder decoder = Base64.getDecoder();

    String[] chunk = AccessToken.split("\\.");
    String payload = new String(decoder.decode(chunk[1]));
    String header = new String(decoder.decode(chunk[0]));

    log.info("AccessToken Header : "+header);
    log.info("AccessToken Payload : "+payload);

    //return payload;
  }

  public Claims getPayload(String accessToken) {
//    Jws<Claims> claimsJws = Jwts.parser().verifyWith(secretKey).build()
//            .parseSignedClaims(accessToken);
//    String IDstr = claimsJws.getPayload().getId();
//    log.info("Jwt 프로바이더 Access Token ID : "+IDstr);
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(accessToken).getPayload();
  }

//  public UserDTO getUserDTO(HttpServletRequest request) {
//    User user = Stream.of(request)
//            .map(i -> extractTokenFromHeader(i))
//            .filter(i -> !i.equals("undefined token"))
//            .map(i -> getPayload(i).get("id", Long.class))
//            .map(id -> userRepository.findById(id))
//            .findFirst()
//            .get();
//
//
//      return UserDTO.builder()
//  }
}
