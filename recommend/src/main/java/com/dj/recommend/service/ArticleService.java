package com.dj.recommend.service;

import java.util.List;

import com.dj.recommend.domain.Article;
import com.dj.recommend.domain.ArticleSO;
import com.dj.recommend.domain.BaseResponse;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/9/6
 */

public interface ArticleService {
    Article create(Article article);

    Article findById(Long id);

    List<Article> search(Article so);

    Article update(Article article);

    BaseResponse<Article> getSomeNew(ArticleSO articleSO);

}
