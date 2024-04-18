package com.linus.api.article.service;

import com.linus.api.article.model.Article;
import com.linus.api.article.model.ArticleDTO;
import com.linus.api.common.command.CommandService;
import com.linus.api.common.query.QueryService;

import java.util.*;

public interface ArticleService extends CommandService<ArticleDTO>, QueryService<ArticleDTO> {

  default Article dtoToEntity(ArticleDTO dto){
    return Article.builder()
            .id(dto.getId())
            .title(dto.getTitle())
            .content(dto.getContent())
            .build();
  }

  default ArticleDTO entityToDto(Article optional){
    return ArticleDTO.builder()
            .id(optional.getId())
            .title(optional.getTitle())
            .content(optional.getContent())
            .writer(optional.getWriter().getUsername())
            .board(optional.getBoard().getId())
            .build();
  }
}
