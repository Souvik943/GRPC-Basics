package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.service.UserService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(8943).addService(new UserService()).build();
        server.start();
        System.out.println("Server is started at : " + server.getPort());
        server.awaitTermination();
    }
}