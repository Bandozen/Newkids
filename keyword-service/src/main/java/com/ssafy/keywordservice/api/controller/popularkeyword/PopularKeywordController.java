package com.ssafy.keywordservice.api.controller.popularkeyword;

import com.ssafy.keywordservice.api.controller.ApiResponse;
import com.ssafy.keywordservice.api.controller.popularkeyword.response.PopularKeywordResponse;
import com.ssafy.keywordservice.api.service.popularkeyword.PopularKeywordQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/keyword-service/api/popular")
public class PopularKeywordController {

    private final PopularKeywordQueryService popularKeywordQueryService;

    // TODO: 2023-09-20 getTopFivePopularKeyword
    @GetMapping
    public ApiResponse<List<PopularKeywordResponse>> getTopFivePopularKeyword() {
        List<PopularKeywordResponse> responses = popularKeywordQueryService.getTopFivePopularKeyword();
        return ApiResponse.ok(responses);
    }
}
