package com.linus.api.common.command;

import com.linus.api.common.component.MessengerVO;

public interface CommandService<T> {
  MessengerVO save(T t);
  MessengerVO deleteById(Long id);
  MessengerVO modify(T t);
}
