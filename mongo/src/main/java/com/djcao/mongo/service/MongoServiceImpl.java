package com.djcao.mongo.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Update.update;

import java.util.List;

import com.djcao.mongo.model.Item;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2019/12/11
 */
@Component
public class MongoServiceImpl implements MongoService{

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Item get(Long id) {
        return mongoTemplate.findOne(new Query(where("id").is(id)),Item.class,"item");
    }

    @Override
    public Item updateItem(Item item) {
        return mongoTemplate
            .findAndModify(new Query(where("id").is(item.getId())),
                update("name", item.getName()).set("picUrl",item.getPicUrl()).set("title",
                    item.getTitle()).set("smallImages",item.getSmallImages()).set("shop.nick",
                    item.getShop().getNick()).set("shop.shopUrl",item.getShop().getShopUrl())
                    .set("shop.desc",item.getShop().getDesc()),
                Item.class, "item");
    }

    @Override
    public boolean delete(Item item) {
        DeleteResult rlt = mongoTemplate.remove(where("id").is(item.getId()), "item");
        return rlt.getDeletedCount()>0;
    }

    @Override
    public List<Item> search(Item item) {
        return mongoTemplate.find(new Query(where("id").is(item.getId())),Item.class,"item");
    }

    @Override
    public Item add(Item item) {
        return mongoTemplate.insert(item,"item");
    }
}
