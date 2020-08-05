package com.chhaya.amsapi.rest.controller;

import java.util.UUID;

import com.chhaya.amsapi.constant.ApiConstants;
import com.chhaya.amsapi.repository.dto.ArticleDto;
import com.chhaya.amsapi.rest.message.SuccessMessage;
import com.chhaya.amsapi.rest.request.ArticleRequest;
import com.chhaya.amsapi.rest.response.ApiResponse;
import com.chhaya.amsapi.rest.response.ArticleResponse;
import com.chhaya.amsapi.service.implement.ArticleServiceImp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstants.API_VERSION)
public class ArticleRestController {

    private ModelMapper mapper;

    private ArticleServiceImp articleServiceImp;

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Autowired
    public ArticleRestController(ArticleServiceImp articleServiceImp) {
        this.articleServiceImp = articleServiceImp;
    }

    
    @GetMapping(ApiConstants.ARTICLES_URL)
    public String getAllArticles() {
        return "All articles";
    }

    @PostMapping(ApiConstants.ARTICLES_URL)
    public ResponseEntity<ApiResponse<ArticleResponse>> saveArticle(
        @RequestBody ArticleRequest articleRequest
    ) {
        
        ApiResponse<ArticleResponse> response = new ApiResponse<>();

        ArticleDto articleDto = mapper.map(articleRequest, ArticleDto.class);

        articleDto.setArticleId(UUID.randomUUID().toString());

        ArticleDto savedArticle = articleServiceImp.save(articleDto);

        ArticleResponse articleResponse = mapper.map(savedArticle, ArticleResponse.class);

        response.setResponse(SuccessMessage.IS_SAVED.value(), true, HttpStatus.CREATED.value(), articleResponse);

        return ResponseEntity.ok(response);

    }

}