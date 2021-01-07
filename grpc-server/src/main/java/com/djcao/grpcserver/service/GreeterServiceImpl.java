package com.djcao.grpcserver.service;

import com.djcao.grpclib.GreeterGrpc;
import com.djcao.grpclib.TestRequest;
import com.djcao.grpclib.TestResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void testSomeThing(TestRequest request, StreamObserver<TestResponse> responseObserver) {
        String message = "Hello " + request.getName();
        TestResponse greeting
                = TestResponse.newBuilder().setMessage(message).build();
        System.out.println("server responded"+ greeting);
        System.out.println("message>>>" + message);
        responseObserver.onNext(greeting);
        responseObserver.onCompleted();
    }
}
