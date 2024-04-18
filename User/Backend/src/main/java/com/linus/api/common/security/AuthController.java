package com.linus.api.common.security;

import com.linus.api.common.component.MessengerVO;
import com.linus.api.common.security.service.AuthService;
import com.linus.api.user.model.UserDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {
  private final AuthService service;

  @PostMapping(path = "/login")
  public ResponseEntity<MessengerVO> login(@RequestBody UserDTO param) {
    return ResponseEntity.ok(service.login(param));
  }
}
