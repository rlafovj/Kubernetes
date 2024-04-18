package com.linus.api.common.component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageVO {
  private Long imageId;
  String name;
  Long lastmodified;
  Long lastmodifiedDate;
  String type;
  String webkitRelativePath;
  Long size;
}
