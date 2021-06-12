package org.grpc.server.hello;
import io.grpc.stub.StreamObserver;
import org.grpc.server.hello.HelloServiceGrpc.HelloServiceImplBase;
import org.grpc.server.hello.Name;
import org.grpc.server.hello.Greetings;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void sayHello(Name name, StreamObserver<Greetings> responseObserver){
        String greeting = new StringBuilder()
                .append("hello, welcome to  ")
                .append(name.getValue())
                .append(" ")
                .toString();
        Greetings greetings = Greetings.newBuilder()
                .setText(greeting)
                .build();
        responseObserver.onNext(greetings);
        responseObserver.onCompleted();
    }

}
