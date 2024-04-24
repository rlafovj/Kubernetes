package com.linus.api.user;

import com.linus.api.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserControllerTest {
  @Autowired
  private UserService userService;

  @Test
  void findAll() {
    List.of(userService.findAll()).forEach(System.out::println);
  }
}