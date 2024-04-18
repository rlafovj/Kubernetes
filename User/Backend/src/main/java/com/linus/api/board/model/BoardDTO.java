package com.linus.api.board.model;

import com.linus.api.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class BoardDTO {
  private Long id;
  private String boardName;
  private String boardType;
//  @Builder.Default
  private List<Article> articles; //= new ArrayList<>();
}
