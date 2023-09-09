package com.ssafy.vocabularyservice.domain.word.repository;

import com.ssafy.vocabularyservice.domain.word.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 단어 Data JPA 저장소
 *
 * @author 임우택
 */
@Repository
public interface WordRepository extends JpaRepository<Word, Long> {
}
