package com.linus.api.user.repository;

import com.linus.api.article.model.Article;
import com.linus.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

  @Modifying
  @Query(" select u from USERS as u where u.token = :id ")
  public List<User> modifyTokenById(@Param("id") Long id);

  Optional<User> findByUsername(String username);

  @Query("select count(id) as count from USERS where username = :username")
  Integer existsUsername(@Param("username") String username);
}
