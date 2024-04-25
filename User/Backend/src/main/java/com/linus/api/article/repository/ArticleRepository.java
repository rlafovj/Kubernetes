package com.linus.api.article.repository;

import com.linus.api.article.model.Article;
import com.linus.api.article.model.ArticleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

  String articleDTOMapping = "new com.linus.api.article.model.ArticleDTO(a.id, a.title, a.content, a.writer.id, a.board.id)";

  //JPQL Default
  @Query(" select a from ARTICLES as a where a.board.id = :boardId ")
  public List<Article> getArticlesByBoardId(@Param("boardId") Long boardId);

  // Native
  @Query(value = " select * from articles a where a.board_id = :boardId ", nativeQuery = true)
  public List<Article> getQnaArticles(@Param("boardId") Long boardId);

  @Query(value = " select * from articles a where a.board_id = :boardId ", nativeQuery = true)
  public List<Map<String, Objects>> getReviewArticles(@Param("boardId") Long boardId);

  //JPSQL Return Type DTO
  @Query(" SELECT " + articleDTOMapping + " FROM ARTICLES a WHERE a.board.id = :boardId ")
  List<ArticleDTO> getArticlesByBoardId3(@Param("boardId") Long boardId);

  List<Article> findAllByOrderByIdDesc();

}
