package com.ssafy.articleservice.domain.article.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.articleservice.api.controller.article.response.ArticleResponse;
import com.ssafy.articleservice.domain.article.repository.dto.ArticleSearchCond;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static com.ssafy.articleservice.domain.article.QArticle.*;

@Repository
public class ArticleQueryRepository {

    private final JPAQueryFactory queryFactory;

    public ArticleQueryRepository(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    public List<ArticleResponse> searchByCondition(ArticleSearchCond cond, Pageable pageable) {
        List<Long> ids = queryFactory
            .select(article.id)
            .from(article)
            .where(article.title.like("%" + cond.getTitle() + "%"))
            .limit(pageable.getPageSize())
            .offset(pageable.getOffset())
            .orderBy(article.publishedDate.desc())
            .fetch();

        if (CollectionUtils.isEmpty(ids)) {
            return new ArrayList<>();
        }

        return queryFactory
            .select(Projections.constructor(ArticleResponse.class,
                article.title,
                article.subTitle,
                article.writer,
                article.publishedDate,
                article.thumbnailImg
            ))
            .from(article)
            .where(article.id.in(ids))
            .orderBy(article.publishedDate.desc())
            .fetch();
    }
}
