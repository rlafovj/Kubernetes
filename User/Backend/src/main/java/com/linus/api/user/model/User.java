package com.linus.api.user.model;

import com.linus.api.article.model.Article;
import com.linus.api.board.model.Board;
import com.linus.api.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name="USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class User extends BaseEntity {
    @Id
    @Column(name= "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Article> articles;

    @Column(name= "USERNAME")
    private String username;

    @Column(name= "PASSWORD")
    private String password;

    @Column(name= "NAME")
    private String name;

    @Column(name= "PHONE")
    private String phone;

    @Column(name= "ADDRESS")
    private String address;

    @Column(name= "JOB")
    private String job;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password,
                String name, String phone,
                String address, String job) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.job = job;
    }
}