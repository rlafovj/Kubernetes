package com.linus.api.user.service;

import com.linus.api.common.component.JwtProvider;
import com.linus.api.common.component.MessengerVO;
import com.linus.api.user.model.User;
import com.linus.api.user.model.UserDTO;
import com.linus.api.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
  private final UserRepository repo;
  private final JwtProvider jwtProvider;

  @Override
  public MessengerVO save(UserDTO dto) {
    entityToDto(repo.save(dtoToEntity(dto)));
    return new MessengerVO();
  }

  @Override
  public MessengerVO deleteById(Long id) {
    repo.deleteById(id);
    return new MessengerVO();
  }

  @Override
  public MessengerVO modify(UserDTO userDTO) {
    return null;
  }

  @Override
  public List<UserDTO> findAll() {
    return repo.findAll().stream().map(i->entityToDto(i)).toList();
  }

  @Override
  public Optional<UserDTO> findById(Long id) {
    //Optional.of(entityToDto(repo.findById(id)));
    return null;
  }

//  @Transactional
//  @Override
//  public MessengerVO login(UserDTO param) {
//
////    boolean flag = repo.findByUsername(param.getUsername()).get().getPassword().equals(param.getPassword());
//    User user = repo.findByUsername(param.getUsername()).get();
//    boolean flag = user.getPassword().equals(param.getPassword());
//
//
//    String AccessToken = jwtProvider.createToken(entityToDto(user));
//    jwtProvider.printPayload(AccessToken);
//
//    return MessengerVO.builder()
//            .message(flag ? "SUCCESS" : "FAIL")
//            .accessToken(flag ? AccessToken : "None")
//            .build();
//  }

  @Override
  public Boolean existsUsername(String username){
    Integer count =repo.existsUsername(username);
    return count  == 1;
  }

  @Override
  public Boolean logout(Long id) {
    return null;
  }

  @Override
  public Boolean logout(String username) {
    return null;
  }

  @Override
  public long count() {
    return repo.count();
  }

  @Override
  public boolean existsById(Long id) {
    return repo.existsById(id);
  }

  @Override
  public List<UserDTO> findUsersByName(String name) {
    throw new UnsupportedOperationException("Unimplemented method 'findUsersByName'");
  }

  @Override
  public List<UserDTO> findUsersByJob(String job) {
    throw new UnsupportedOperationException("Unimplemented method 'findUsersByJob'");
  }

  @Override
  public Optional<User> findUserByUsername(String username) {
    return repo.findByUsername(username);
  }

  @Transactional
  @Override
  public MessengerVO login(UserDTO dto) {
    log.info("로그인 서비스로 들어온 파라미터 : "+dto);
    User user = repo.findByUsername(dto.getUsername()).get();
    String accessToken = jwtProvider.createToken(entityToDto(user));
    boolean flag = user.getPassword().equals(dto.getPassword());
    // passwordEncoder.matches

    // 토큰을 각 섹션(Header, Payload, Signature)으로 분할
    jwtProvider.printPayload(accessToken);

    return MessengerVO.builder()
            .message(flag ? "SUCCESS" : "FAILURE")
            .accessToken(flag ? accessToken : "None")
            .build();
  }
}
