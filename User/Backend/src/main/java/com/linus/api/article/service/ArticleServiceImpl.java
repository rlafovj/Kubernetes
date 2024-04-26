package com.linus.api.article.service;

import com.linus.api.article.repository.ArticleRepository;
import com.linus.api.article.model.Article;
import com.linus.api.article.model.ArticleDTO;
import com.linus.api.board.model.Board;
import com.linus.api.board.repository.BoardRepository;
import com.linus.api.common.component.MessengerVO;
import com.linus.api.common.component.PageRequestVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final ArticleRepository repo;
    private final BoardRepository boardRepo;

    @Override
    public MessengerVO save(ArticleDTO param) {
        Board board = boardRepo.findById(param.getBoard()).orElseThrow(() -> new IllegalArgumentException("Invalid board ID: " + param.getBoard()));
        Article ent = repo.save(dtoToEntity(param));
        System.out.println((ent instanceof Article) ? "SUCCESS" : "FAIL");
        return MessengerVO.builder()
                .message((ent instanceof Article) ? "SUCCESS" : "FAIL")
                .id(ent.getBoard().getId())
                .build();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repo.deleteById(id);
      return new MessengerVO();
    }

    @Override
    public MessengerVO modify(ArticleDTO dto) {
        return null;
    }

    @Override
    public List<ArticleDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(i->entityToDto(i))
                .toList();
    }

    @Override
    public Optional<ArticleDTO> findById(Long id) {
        return null;
        //Optional.of(entityToDto(repo.findById(id)));
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

}
