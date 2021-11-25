package com.chhaya.amsapi.service.implement;

import com.chhaya.amsapi.repository.ArticleRepository;
import com.chhaya.amsapi.repository.dto.ArticleDto;
import com.chhaya.amsapi.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ArticleServiceImp implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImp(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    
    
    @Override
    public ArticleDto save(ArticleDto articleDto) {
        try {
            articleRepository.save(articleDto);
            return articleDto;
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

    @Override
    public ArticleDto update(ArticleDto articleDto) {
        try {
            articleRepository.update(articleDto);
            return articleRepository.selectByArticleId(articleDto.getArticleId());
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

    @Override
    public List<ArticleDto> findAll() {
        try {
            return articleRepository.select();
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

    @Override
    public List<ArticleDto> findRecentArticles() {
        try {
            return articleRepository.selectRecentArticles();
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

    @Override
    public List<ArticleDto> findPopularArticles() {
        try {
            return articleRepository.selectPopularArticles();
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

    @Override
    public ArticleDto findArticle(String articleId) {
        try {
            ArticleDto article = articleRepository.selectByArticleId(articleId);
            if (article == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "The article hasn't been found in the database");
            }
            return article;
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

    @Override
    public ArticleDto delete(String articleId) {
        try {
            ArticleDto article = articleRepository.selectByArticleId(articleId);
            if (article == null) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "The article hasn't been found in the database");
            }
            articleRepository.delete(articleId);
            return article;
        } catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getCause().getMessage());
        }
    }

}