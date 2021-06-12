package org.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.grpc.server.hello.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {
    public static void main(String[] args) throws Exception
    {
      Server server = ServerBuilder
              .forPort(8080)
              .addService(new HelloServiceImpl()).build();
      server.start();
      server.awaitTermination();
//        SpringApplication.run(ServerApplication.class, args);
    }
}
