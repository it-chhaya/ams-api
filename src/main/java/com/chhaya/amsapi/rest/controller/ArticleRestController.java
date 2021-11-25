package com.chhaya.amsapi.rest.controller;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(ApiConstants.POPULAR_ARTICLES_URL)
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getPopularArticles() {

        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();

        List<ArticleDto> popularArticleDtoList = articleServiceImp.findPopularArticles();

        List<ArticleResponse> popularArticleResponseList = new ArrayList<>();

        for (ArticleDto popularArticleDto : popularArticleDtoList)
            popularArticleResponseList.add(mapper.map(popularArticleDto, ArticleResponse.class));

        if (popularArticleResponseList.size() == 0) {
            response.setResponse(SuccessMessage.HAS_NO_RECORD.value(),
                    false,
                    HttpStatus.NO_CONTENT.value(),
                    null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.setResponse(SuccessMessage.FOUND_ALL.value(),
                    true,
                    HttpStatus.OK.value(),
                    popularArticleResponseList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    @GetMapping(ApiConstants.RECENT_ARTICLES_URL)
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getRecentArticles() {

        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();

        List<ArticleDto> recentArticleDtoList = articleServiceImp.findRecentArticles();

        List<ArticleResponse> recentArticleResponseList = new ArrayList<>();

        for (ArticleDto recentArticleDto : recentArticleDtoList)
            recentArticleResponseList.add(mapper.map(recentArticleDto, ArticleResponse.class));

        if (recentArticleResponseList.size() == 0) {
            response.setResponse(SuccessMessage.HAS_NO_RECORD.value(),
                    false,
                    HttpStatus.NO_CONTENT.value(),
                    null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.setResponse(SuccessMessage.FOUND_ALL.value(),
                    true,
                    HttpStatus.OK.value(),
                    recentArticleResponseList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

    }

    
    @GetMapping(ApiConstants.ARTICLES_URL)
    public ResponseEntity<ApiResponse<List<ArticleResponse>>> getAllArticles() {

        ApiResponse<List<ArticleResponse>> response = new ApiResponse<>();

        List<ArticleDto> articleDtoList = articleServiceImp.findAll();

        List<ArticleResponse> articleResponseList = new ArrayList<>();

        for (ArticleDto articleDto : articleDtoList) {
            articleResponseList.add(mapper.map(articleDto, ArticleResponse.class));
        }

        if (articleResponseList.size() == 0) {
            response.setResponse(SuccessMessage.HAS_NO_RECORD.value(),
                    false,
                    HttpStatus.NO_CONTENT.value(),
                    null);
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            response.setResponse(SuccessMessage.FOUND_ALL.value(),
                    true,
                    HttpStatus.OK.value(),
                    articleResponseList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

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

    @PutMapping(ApiConstants.ARTICLES_URL + "/{articleId}")
    public ResponseEntity<ApiResponse<ArticleResponse>> updateArticle(@PathVariable("articleId") String articleId, @RequestBody ArticleRequest articleRequest) {

        ApiResponse<ArticleResponse> response = new ApiResponse<>();

        ArticleDto articleDto = mapper.map(articleRequest, ArticleDto.class);

        articleDto.setArticleId(articleId);

        ArticleDto updatedArticle = articleServiceImp.update(articleDto);

        ArticleResponse articleResponse = mapper.map(updatedArticle, ArticleResponse.class);

        response.setResponse(SuccessMessage.IS_UPDATED.value(), true, HttpStatus.OK.value(), articleResponse);

        return ResponseEntity.ok(response);
    }

    @GetMapping(ApiConstants.ARTICLES_URL + "/{articleId}")
    public ResponseEntity<ApiResponse<ArticleResponse>> findArticle(@PathVariable String articleId) {
        ApiResponse<ArticleResponse> response = new ApiResponse<>();
        ArticleDto articleDto = articleServiceImp.findArticle(articleId);
        ArticleResponse articleResponse = mapper.map(articleDto, ArticleResponse.class);
        response.setResponse(SuccessMessage.FOUND_ONE.value(), true, HttpStatus.OK.value(), articleResponse);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(ApiConstants.ARTICLES_URL + "/{articleId}")
    public ResponseEntity<ApiResponse<ArticleResponse>> deleteArticle(@PathVariable String articleId) {
        ApiResponse<ArticleResponse> response = new ApiResponse<>();
        ArticleDto articleDto = articleServiceImp.delete(articleId);
        ArticleResponse articleResponse = mapper.map(articleDto, ArticleResponse.class);
        response.setResponse(SuccessMessage.FOUND_ONE.value(), true, HttpStatus.OK.value(), articleResponse);

        return ResponseEntity.ok(response);
    }



}