package com.djcao.mongo.service;

import java.util.List;

import com.djcao.mongo.model.Item;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/11
 */
public interface MongoService {

    Item get(Long id);

    Item updateItem(Item item);

    boolean delete(Item item);

    List<Item> search(Item item);

    Item add(Item item);
}
