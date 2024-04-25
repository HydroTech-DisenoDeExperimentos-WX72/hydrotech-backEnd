package com.hydrotech.backend.service;

import com.hydrotech.backend.model.Article;


public interface ArticleService {

    /**
     * Creates a new article.
     *
     * @param article The article to be created.
     * @return The created article.
     */
    Article createArticle(Article article);
}
