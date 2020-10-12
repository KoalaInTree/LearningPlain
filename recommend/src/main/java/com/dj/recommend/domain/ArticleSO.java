package com.dj.recommend.domain;

import java.util.Date;

import lombok.Data;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/9/6
 */
@Data
public class ArticleSO extends BaseSO{
    private Long id;
    private String title;
    private Date createdTime;
    private Date updatedTime;
    private Long userId;
    private Long tagId;
    private String content;
}
