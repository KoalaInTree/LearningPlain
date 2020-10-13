package com.dj.recommend;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

import com.dj.recommend.dao.ArticleMapper;
import com.dj.recommend.domain.Article;
import com.dj.recommend.domain.ArticleSO;
import com.dj.recommend.domain.BaseResponse;
import com.dj.recommend.service.ArticleService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RecommendApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() {
        Article article = new Article();
        article.setContent("123");
        article.setTagId(1L);
        article.setTitle("8848");
        article.setUserId(2L);
        articleService.create(article);
        Assert.assertNotNull(article.getId());
    }

    @Test
    void bashInsert() {
        LongStream.range(3,100000).forEach(x ->{
            Article article = new Article();
            article.setContent("123"+x);
            article.setTagId(x);
            article.setTitle("8848"+x);
            article.setUserId(x);
            articleService.create(article);
        });
    }

    @Test
    void getSomeNew() {
        ArticleSO so = new ArticleSO();
        so.setTitle("8848");
        BaseResponse<Article> someNew = articleService.getSomeNew(so);
        Assert.assertNotNull(someNew.getVos());
    }

}
