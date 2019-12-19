package com.djcao.mongo.model;

import lombok.Data;

/**
 * @author djcao
 * @date 2019/12/19 10:59 
 */
@Data
public class Shop {
    private Long id;

    private String nick;

    private String shopUrl;

    private String desc;
}
