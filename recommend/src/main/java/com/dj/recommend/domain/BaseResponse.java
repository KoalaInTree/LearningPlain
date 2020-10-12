package com.dj.recommend.domain;

import java.util.List;

import lombok.Data;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/9/6
 */
@Data
public class BaseResponse<T> {

    private long current;

    private long size;

    private long total;

    private List<T> vos;
}
