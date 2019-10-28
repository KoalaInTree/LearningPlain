package com.djcao.flux.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.djcao.flux.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    private Map<String, User> userMap = new ConcurrentHashMap<>();

    public void setUser(String userId, User user) {
        System.out.println(Thread.currentThread().getName());
        userMap.put(userId, user);
    }

    public Mono<User> findUserById(String userId) {
        System.out.println(Thread.currentThread().getName());
        User user = userMap.getOrDefault(userId, new User("nick", 18));
        return Mono.just(user);
    }

    public Flux<User> findUserList() {
        System.out.println(Thread.currentThread().getName());
        List<User> userList = new ArrayList<>();
        Set<Entry<String, User>> entries = userMap.entrySet();
        entries.stream().forEach(entry -> userList.add(entry.getValue()));
        return Flux.fromStream(userList.stream());
    }
}