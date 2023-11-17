package com.greengrow.backend.service.impl;

import com.greengrow.backend.model.Article;
import com.greengrow.backend.repository.ArticleRepository;
import com.greengrow.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article createArticle(Article article){
        return articleRepository.save(article);
    }
}
