package com.linus.api.board;


import com.linus.api.board.model.BoardDTO;
import com.linus.api.board.service.BoardService;
import com.linus.api.common.component.PageRequestVO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/api/boards")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @GetMapping("list")
    public ResponseEntity<List<BoardDTO>> findAll() throws SQLException {
        return ResponseEntity.ok(service.findAll());
    }
}
