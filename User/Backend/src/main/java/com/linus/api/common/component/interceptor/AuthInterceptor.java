package com.linus.api.common.component.interceptor;

import com.linus.api.common.component.JwtProvider;
import com.linus.api.user.model.User;
import com.linus.api.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

  private final JwtProvider jwtProvider;
  private final UserRepository userRepository;
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//    String token = jwtProvider.extractTokenFromHeader(request);
//    log.info("1- 인터셉터 토큰 로그 Bearer 포함 : {}", token);
//
//    if(token.equals("undefined token")){
//      response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//      return false;
//    }
//
//    Long id = jwtProvider.getPayload(token).get("id", Long.class);
//    log.info("2- 인터셉터 사용자 ID : {}", id);
//
//    Optional<User> user = userRepository.findById(id);
//    log.info("3- 인터셉터 사용자 정보 : {}", user);
//
//    if(!user.isPresent()){
//      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
//      return false;
//    }
//    log.info("4- 인터셉터 최종 여부 : {}", true);

    return Stream.of(request)
            .map(i -> jwtProvider.extractTokenFromHeader(i))
            .filter(i -> !i.equals("undefined token"))
            .peek(token -> log.info("1- 인터셉터 토큰 로그 Bearer 포함 : {}", token))
            .map(i -> jwtProvider.getPayload(i).get("id", Long.class))
            .map(id -> userRepository.findById(id))
            .filter(i -> i.isPresent())
            .peek(id -> log.info("2- 인터셉트사용자 ID : {}", id))
            .findFirst()
            .isPresent();



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
