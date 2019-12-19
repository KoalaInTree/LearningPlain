package com.djcao.mongo.controller;

import java.util.List;

import com.djcao.mongo.model.Item;
import com.djcao.mongo.service.MongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author djcao
 * @date 2019/12/19 10:59 
 */
@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private MongoService mongoService;

    @RequestMapping("save")
    @ResponseBody
    public Item save(@RequestBody Item item){
        return mongoService.add(item);
    }

    @RequestMapping("remove")
    @ResponseBody
    public boolean remove(@RequestBody Item item){
        return mongoService.delete(item);
    }

    @RequestMapping("get")
    @ResponseBody
    public Item save(@RequestBody Long id){
        return mongoService.get(id);
    }

    @RequestMapping("search")
    @ResponseBody
    public List<Item> search(@RequestBody Item item){
        return mongoService.search(item);
    }

    @RequestMapping("update")
    @ResponseBody
    public Item update(@RequestBody Item item){
        return mongoService.updateItem(item);
    }
}
