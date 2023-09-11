package com.ssafy.vocabularyservice.api.controller.vocabulary.response;

import com.ssafy.vocabularyservice.domain.word.Word;
import lombok.Builder;
import lombok.Data;

@Data
public class WordResponse {

    private String wordKey;
    private String content;
    private String description;
    private Boolean check;

    @Builder
    public WordResponse(String wordKey, String content, String description, boolean check) {
        this.wordKey = wordKey;
        this.content = content;
        this.description = description;
        this.check = check;
    }

    // TODO: 2023-09-11 임우택 check 여부 수정
    public static WordResponse of(Word word) {
        return WordResponse.builder()
            .wordKey(word.getWordKey())
            .content(word.getContent())
            .description(word.getDescription())
            .build();
    }
}
