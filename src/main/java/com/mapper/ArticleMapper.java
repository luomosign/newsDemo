package com.mapper;

import com.entity.Article;
import com.entity.Nav;

import java.util.List;

public interface ArticleMapper {
    List<Article> queryAllArticle();
    List<Article> queryArticleByTitle(Article article);
    void addArticle(Article article);
    void updateArticle(Article article);
    void deleteArticle(Article article);
}
