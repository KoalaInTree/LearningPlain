package com.dj.recommend.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.recommend.dao.ArticleMapper;
import com.dj.recommend.domain.Article;
import com.dj.recommend.domain.ArticleSO;
import com.dj.recommend.domain.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/9/6
 */
@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public Article create(Article article) {
        articleMapper.insert(article);
        return article;
    }

    @Override
    public Article findById(Long id) {
        return articleMapper.selectById(id);
    }

    @Override
    public List<Article> search(Article so) {
        return null;
    }

    @Override
    public Article update(Article article) {
        articleMapper.updateById(article);
        return article;
    }

    @Override
    public BaseResponse<Article> getSomeNew(ArticleSO articleSO) {
        BaseResponse<Article> rsp = new BaseResponse<>();
        Page<Article> page = new Page<>(articleSO.getCurrent(),articleSO.getSize());
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("title", articleSO.getTitle());
        articleMapper.selectPage(page, queryWrapper);
        rsp.setTotal(page.getTotal());
        rsp.setVos(page.getRecords());
        return rsp;
    }
}
