package com.djcao.flux.model;

import lombok.Data;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-24
 */
@Data
public class User {
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    private Long id;
    private String name;
    private Integer age;
}
