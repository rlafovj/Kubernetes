package com.linus.api.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;
import org.springframework.format.datetime.DateFormatter;


@Configuration
public class ServerConfig {
  @Bean
  public String datePattern(){
    return "yyy-MM-dd'T'HH:mm:ss.XXX";
  }
  @Bean
  public DateFormatter defaultDateFormatter(){
    return new DateFormatter(datePattern());
  }
}
