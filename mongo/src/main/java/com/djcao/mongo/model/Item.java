package com.djcao.mongo.model;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/11
 */
@Data
public class Item {

    private String id;

    private String name;

    private String picUrl;

    private String title;

    private Shop shop;

    private List<String> smallImages;

}
