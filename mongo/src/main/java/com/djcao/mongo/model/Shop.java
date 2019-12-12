package com.djcao.mongo.model;

import lombok.Data;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/11
 */
@Data
public class Shop {
    private Long id;

    private String nick;

    private String shopUrl;

    private String desc;
}
