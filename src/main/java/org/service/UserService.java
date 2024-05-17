package org.service;

import io.grpc.stub.StreamObserver;
import org.stubs.User;
import org.stubs.userGrpc;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("Inside Login Method");
        String username = request.getUsername();
        String password = request.getPassword();

        User.APIResponse.Builder response = User.APIResponse.newBuilder();
        if(username.equals(password)) {
            response.setResponseCode(200).setResponseMessage("Success");
        }
        else {
            response.setResponseCode(404).setResponseMessage("Failure");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {

    }
}
