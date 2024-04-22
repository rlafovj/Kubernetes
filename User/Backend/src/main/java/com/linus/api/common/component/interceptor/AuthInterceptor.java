package com.linus.api.common.component.interceptor;

import com.linus.api.common.component.JwtProvider;
import com.linus.api.user.model.User;
import com.linus.api.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

  private final JwtProvider jwtProvider;
  private final UserRepository userRepository;
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = jwtProvider.extractTokenFromHeader(request);
    if(ObjectUtils.isEmpty(token)){
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    }
    String strId = jwtProvider.getPayload(token);
    Long id = Long.parseLong(strId);

    Optional<User> user = userRepository.findById(null);

    if(ObjectUtils.isEmpty(user)){
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}