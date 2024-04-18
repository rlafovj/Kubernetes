package com.linus.api.article.model;

import com.linus.api.board.model.Board;
import com.linus.api.common.BaseEntity;
import com.linus.api.user.model.User;
import jakarta.persistence.*;
import lombok.*;

@Entity(name= "ARTICLES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Article extends BaseEntity {
    @Id
    @Column(name= "ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_ID")
    private Board board;

    @Column(name= "TITLE")
    private String title;

    @Column(name= "CONTENT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "WRITER")
    private User writer;

    @Builder(builderMethodName = "builder")
    public Article(Long id, String title, String content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}