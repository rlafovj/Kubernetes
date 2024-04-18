package com.linus.api.common.security.service;

import com.linus.api.common.component.MessengerVO;
import com.linus.api.user.model.User;
import com.linus.api.user.model.UserDTO;

import java.util.Optional;

public interface AuthService {
  public MessengerVO login(UserDTO param);
  public Optional<User> findUserByUsername(String username);
  String createToken(UserDTO user);
}
