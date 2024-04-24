package com.linus.api.common.security.service;

import com.linus.api.common.component.JwtProvider;
import com.linus.api.common.component.MessengerVO;
import com.linus.api.user.model.User;
import com.linus.api.user.model.UserDTO;
import com.linus.api.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{
  private final UserRepository repo;
  private final JwtProvider jwtProvider;
  @Transactional
  @Override
  public MessengerVO login(UserDTO param) {

//    boolean flag = repo.findByUsername(param.getUsername()).get().getPassword().equals(param.getPassword());
    User user = repo.findByUsername(param.getUsername()).get();
    boolean flag = user.getPassword().equals(param.getPassword());


    String AccessToken = jwtProvider.createToken(entityToDto(user));
    jwtProvider.printPayload(AccessToken);

    return MessengerVO.builder()
            .message(flag ? "SUCCESS" : "FAIL")
            .accessToken(flag ? AccessToken : "None")
            .build();

  }

  @Override
  public Optional<User> findUserByUsername(String username) {
    return repo.findByUsername(username);
  }

  @Override
  public String createToken(UserDTO user) {
    Claims claims = (Claims) Jwts.claims();
    claims.put("username", user.getUsername());

    LocalDateTime now = LocalDateTime.now();
    LocalDateTime tokenValidTime = now.plusSeconds(24 * 60 * 60 * 1000);

    String token =  Jwts.builder()
            .claims()
            .issuer("linus.com")
            .add("sub","UserAuth")
            .add("exp",tokenValidTime)
            .add("userId",user.getId())
            .add("username",user.getUsername())
            .add("job","admin")
            .and()
            .compact();

    log.info("로그인성공으로 발급된 토큰 : " + token);
    return token;
  }

  @Override
  public MessengerVO save(UserDTO userDTO) {
    return null;
  }

  @Override
  public MessengerVO deleteById(Long id) {
    return null;
  }

  @Override
  public MessengerVO modify(UserDTO userDTO) {
    return null;
  }

  @Override
  public List<UserDTO> findAll() {
    return null;
  }

  @Override
  public Optional<UserDTO> findById(Long id) {
    return Optional.empty();
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public boolean existsById(Long id) {
    return false;
  }
}
