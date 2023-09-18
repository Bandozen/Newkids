package com.ssafy.articleservice.api.controller.article;

import com.ssafy.articleservice.api.controller.ApiResponse;
import com.ssafy.articleservice.api.controller.article.response.ArticleDetailResponse;
import com.ssafy.articleservice.api.controller.article.response.ArticleResponse;
import com.ssafy.articleservice.api.service.article.ArticleQueryService;
import com.ssafy.articleservice.api.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/article-service")
public class ArticleController {

    private final ArticleService articleService;
    private final ArticleQueryService articleQueryService;

    // TODO: 2023/09/13 뉴스 기사 조회 API
    @GetMapping
    public ApiResponse<Page<ArticleResponse>> getArticles() {
        Page<ArticleResponse> response = articleQueryService.getArticles();
        return ApiResponse.ok(null);
    }

    /**
     * 뉴스 기사 상세 조회 API
     * @param articleId 조회할 기사의 PK
     * @return 조회된 뉴스 기사의 정보
     */
    @GetMapping("/{articleId}")
    public ApiResponse<ArticleDetailResponse> getArticle(@PathVariable Long articleId) {
        log.debug("ArticleController#getArticle");
        log.debug("request={}", articleId);

        ArticleDetailResponse response = articleQueryService.getArticle(articleId);
        log.debug("response={}", response);

        return ApiResponse.ok(response);
    }

    // TODO: 2023/09/13 뉴스 기사 삭제 API
    @DeleteMapping("/{articleId}")
    @ResponseStatus(HttpStatus.FOUND)
    public ApiResponse<ArticleResponse> removeArticle(@PathVariable Long articleId) {
        articleService.removeArticle(articleId);
        return ApiResponse.found(null);
    }
}
