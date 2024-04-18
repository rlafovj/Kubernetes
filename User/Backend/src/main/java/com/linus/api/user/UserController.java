package com.linus.api.user;

import com.linus.api.common.component.MessengerVO;

import com.linus.api.user.model.User;
import com.linus.api.user.model.UserDTO;
import com.linus.api.user.repository.UserRepository;
import com.linus.api.user.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins ="*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
@Slf4j

public class UserController {
    private final UserService service;
    private final UserRepository repo;

    // -------------------- Command ---------------------------

    @PostMapping(path = "/join")
    public ResponseEntity<MessengerVO> save(@RequestBody UserDTO param) {
        log.info("입력받은 정보 : {}", param );
        service.save(param);
        return ResponseEntity.ok(new MessengerVO());

    }

    // -------------------- Query ---------------------------

    @PostMapping(path = "/login")
    public ResponseEntity<MessengerVO> login(@RequestBody UserDTO param) {
        //User user = service.findByUsername(username).orElse(null);

        return ResponseEntity.ok(service.login(param));
    }


    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> findAll() throws SQLException {

        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(path="/detail")

    public ResponseEntity<Optional<UserDTO>> findUserById(@RequestParam Long id) {

        return ResponseEntity.ok(Optional.of(new UserDTO()));
    }



    @PutMapping("/modify")
    public ResponseEntity<MessengerVO> updatePassword(@RequestBody Map<?, ?> paramap) {

        return ResponseEntity.ok(new MessengerVO());
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessengerVO> deleteById(@PathVariable long id) throws SQLException {
        return ResponseEntity.ok(service.deleteById(id));
    }


    @GetMapping("/user-list")
    public ResponseEntity<MessengerVO> getUserList() {

        return ResponseEntity.ok(new MessengerVO());
    }


    @GetMapping("/find-userbyname")
    public ResponseEntity<MessengerVO> findUserByName(@RequestBody Map<?, ?> paramap) {
        return ResponseEntity.ok(new MessengerVO());

    }


    @GetMapping("/find-userbyjob")
    public ResponseEntity<MessengerVO> findUserByJob(@RequestBody Map<?, ?> paramap) {
        return ResponseEntity.ok(new MessengerVO());
    }


    @GetMapping("/api/count-users")
    public ResponseEntity<MessengerVO> countUser() {
        return ResponseEntity.ok(new MessengerVO());

    }

    @GetMapping("/get-one")
    public ResponseEntity<MessengerVO> getOne(@RequestBody Map<?, ?> paramap) throws SQLException {
        return ResponseEntity.ok(new MessengerVO());
    }


    @GetMapping("/find-users")
    public ResponseEntity<MessengerVO> findUsers() throws SQLException {

        return ResponseEntity.ok(new MessengerVO());
    }


    @GetMapping("/get-user")
    public ResponseEntity<MessengerVO> getUser(@RequestBody Map<?, ?> paramap) throws SQLException {

        return ResponseEntity.ok(new MessengerVO());
    }


    @GetMapping("/touch-table")
    public ResponseEntity<MessengerVO> touchTable() throws SQLException {
        return ResponseEntity.ok(new MessengerVO());
    }


    @GetMapping("/remove-table")
    public ResponseEntity<MessengerVO> removeTable() throws SQLException {
        return ResponseEntity.ok(new MessengerVO());
    }

}
