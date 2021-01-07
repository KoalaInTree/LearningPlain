package com.djcao.grpcclient.controller;

import com.djcao.grpcclient.server.HelloWorldClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrpcController {

    @Autowired
    private HelloWorldClient helloWorldClient;

    @RequestMapping("hello")
    public String sayHello(@RequestParam String hello) {
        return helloWorldClient.sayHello(hello);
    }
}
