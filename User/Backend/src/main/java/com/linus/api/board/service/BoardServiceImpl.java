package com.linus.api.board.service;

import com.linus.api.board.model.BoardDTO;
import com.linus.api.board.repository.BoardRepository;
import com.linus.api.common.component.MessengerVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository repo;

    @Override
    public MessengerVO save(BoardDTO dto) {
        entityToDto(Optional.of(repo.save(dtoToEntity(dto))));
        return new MessengerVO();
    }

    @Override
    public MessengerVO deleteById(Long id) {
        repo.deleteById(id);
        return new MessengerVO();
    }

    @Override
    public MessengerVO modify(BoardDTO boardDTO) {
        return null;
    }

    @Override
    public List<BoardDTO> findAll() {
        return repo.findAll().stream().map(i->entityToDto(Optional.ofNullable(i))).toList();
    }

    @Override
    public Optional<BoardDTO> findById(Long id) {
        return Optional.of(entityToDto(repo.findById(id)));
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
