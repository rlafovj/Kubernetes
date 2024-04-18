package com.linus.api.user.service;

import com.linus.api.common.component.MessengerVO;
import com.linus.api.user.model.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceImplTest {
  @Autowired
    private UserService userService;
  @Test
  void count() {
    long totalUsers = userService.count();

    assertThat(totalUsers).isEqualTo(15L);
  }

  @Transactional
  @Test
  void save() {
    UserDTO userDTO = new UserDTO();
    userDTO.setName("test");
    // userDTO 필드 설정 (예: userDTO.setName("test");)

    MessengerVO result = userService.save(userDTO);

    assertNotNull(result, "The returned MessengerVO should not be null");
  }

  @Transactional
  @Test
  void deleteById() {
    UserDTO userDTO = new UserDTO();
    // userDTO 필드 설정

    MessengerVO saveResult = userService.save(userDTO);
    assertNotNull(saveResult, "The returned MessengerVO from save should not be null");

    Long userId = 12L;
            MessengerVO deleteResult = userService.deleteById(userId);

    assertNotNull(deleteResult, "The returned MessengerVO from deleteById should not be null");
  }

  @Transactional
  @Test
  void findAll() {
    List<UserDTO> users = userService.findAll();

    assertNotNull(users, "The returned user list should not be null");
    assertTrue(users.size() > 0, "The returned user list should contain at least one user");
  }

  @Test
  void testCount() {
  }
}