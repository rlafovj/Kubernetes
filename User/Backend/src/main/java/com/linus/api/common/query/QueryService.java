package com.linus.api.common.query;

import com.linus.api.common.component.PageRequestVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface QueryService<T> {
  List<T> findAll();  //전체목록
  Optional<T> findById(Long id); //아이디찾기(컴퓨터용)
  long count(); //저장된회원수
  boolean existsById(Long id);
}
