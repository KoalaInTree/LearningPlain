package com.djcao.grpcclient.server;

import com.djcao.grpclib.GreeterGrpc;
import com.djcao.grpclib.TestRequest;
import com.djcao.grpclib.TestResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorldClient {

    private GreeterGrpc.GreeterBlockingStub greeterStub;

    @PostConstruct
    private void init() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        greeterStub = GreeterGrpc.newBlockingStub(managedChannel);
    }

    public String sayHello(String hello) {
        TestRequest person = TestRequest.newBuilder().setName(hello).build();
        System.out.println("client sending " + person);

        TestResponse greeting = greeterStub.testSomeThing(person);
        System.out.println("client received " + greeting);

        return greeting.getMessage();
    }
}