package com.linus.api.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Builder
@AllArgsConstructor
public class PageRequestFileVO {
  private int page;
  private int size;
  private String type;
  private String keyword;

  private List<?> pageFileDTO;

  public PageRequestFileVO() {
    this.page = 1;
    this.size = 10;
  }

  public Pageable getPageable(Sort sort){
    return PageRequest.of(page - 1, size, sort);
  }
}
