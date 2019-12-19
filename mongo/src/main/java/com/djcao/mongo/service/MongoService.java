package com.djcao.mongo.service;

import java.util.List;

import com.djcao.mongo.model.Item;

/**
 * @author djcao
 * @date 2019/12/19 10:59 
 */
public interface MongoService {

    Item get(Long id);

    Item updateItem(Item item);

    boolean delete(Item item);

    List<Item> search(Item item);

    Item add(Item item);
}
