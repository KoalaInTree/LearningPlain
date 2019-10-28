package com.djcao.flux.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.djcao.flux.model.User;
import com.djcao.flux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019-10-24
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("get/{user}")
    public Mono<User> getUser(@PathVariable("user") String  id){
        return userService.findUserById(id);
    }

    @PostMapping("add/{id}")
    public Mono<User> getUser(@PathVariable("id") String id,@RequestBody User user){
        userService.setUser(id,user);
        return Mono.just(user);
    }

    @GetMapping("delete/{user}")
    public Mono<User> deleteUser(@PathVariable("user") Long id){
        return Mono.just(new User("delete",11));
    }

    @GetMapping("getAll")
    public Flux<User> findUserList(){
        String i = "";
        Flux<User> userList = userService.findUserList();
        System.out.println(123);
        return userList;
    }
}
