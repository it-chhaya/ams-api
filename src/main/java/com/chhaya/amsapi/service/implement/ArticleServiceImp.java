package com.chhaya.amsapi.service.implement;

import com.chhaya.amsapi.repository.ArticleRepository;
import com.chhaya.amsapi.repository.dto.ArticleDto;
import com.chhaya.amsapi.service.ArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

}