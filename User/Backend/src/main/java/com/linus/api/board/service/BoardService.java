package com.linus.api.board.service;

import com.linus.api.article.model.Article;
import com.linus.api.article.model.ArticleDTO;
import com.linus.api.board.model.Board;
import com.linus.api.board.model.BoardDTO;
import com.linus.api.common.command.CommandService;
import com.linus.api.common.query.QueryService;

import java.util.*;

public interface BoardService extends CommandService<BoardDTO>, QueryService<BoardDTO> {
    default Board dtoToEntity(BoardDTO dto){
        return Board.builder()
                .id(dto.getId())
                .boardName(dto.getBoardName())
                .boardType(dto.getBoardType())
                .build();
        // boardID 로 DB 를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우.
    }
    default BoardDTO entityToDto(Optional<Board> board){
      return BoardDTO.builder()
              .id(board.get().getId())
              .boardName(board.get().getBoardName())
              .boardType(board.get().getBoardType())
                .build();
    }
}
