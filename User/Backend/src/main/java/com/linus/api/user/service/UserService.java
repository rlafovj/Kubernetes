package com.linus.api.user.service;


import com.linus.api.common.command.CommandService;
import com.linus.api.common.component.MessengerVO;
import com.linus.api.common.query.QueryService;
import com.linus.api.user.model.User;
import com.linus.api.user.model.UserDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserService extends CommandService<UserDTO>, QueryService<UserDTO> {
  MessengerVO modify(UserDTO user);
  List<UserDTO> findUsersByName(String name);
  List<UserDTO> findUsersByJob(String job);
  Optional<User> findUserByUsername(String username);

  @Override
  Optional<UserDTO> findById(Long id);

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

  MessengerVO login(UserDTO param);
}
