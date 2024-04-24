package com.linus.api.common.security.service;

import com.linus.api.common.command.CommandService;
import com.linus.api.common.component.MessengerVO;
import com.linus.api.common.query.QueryService;
import com.linus.api.user.model.User;
import com.linus.api.user.model.UserDTO;

import java.util.Optional;

public interface AuthService extends CommandService<UserDTO>, QueryService<UserDTO> {
  public MessengerVO login(UserDTO param);
  public Optional<User> findUserByUsername(String username);
  String createToken(UserDTO user);
  default User dtoToEntity(UserDTO dto){
    return User.builder()
            .id(dto.getId())
            .username(dto.getUsername())
            .password(dto.getPassword())
            .name(dto.getName())
            .phone(dto.getPhone())
            .address(dto.getAddress())
            .job(dto.getJob())
            .build();
  }

  default UserDTO entityToDto(User user){
    return UserDTO.builder()
            .id(user.getId())
            .username(user.getUsername())
            .password(user.getPassword())
            .name(user.getName())
            .phone(user.getPhone())
            .address(user.getAddress())
            .job(user.getJob())
            .build();
  }
}
