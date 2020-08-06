package com.chhaya.amsapi.service;

import com.chhaya.amsapi.repository.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    
    ArticleDto save(ArticleDto articleDto);

    List<ArticleDto> findAll();

    List<ArticleDto> findRecentArticles();

    List<ArticleDto> findPopularArticles();

}