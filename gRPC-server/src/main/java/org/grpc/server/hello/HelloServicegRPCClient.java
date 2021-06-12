package org.grpc.server.hello;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloServicegRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub
                = HelloServiceGrpc.newBlockingStub(channel);

        Greetings greetings = stub.sayHello(Name.newBuilder()
                .setValue("gRPC")
                .build());
        System.out.println("response from server -> "+greetings.getText());
        channel.shutdown();
    }

}
