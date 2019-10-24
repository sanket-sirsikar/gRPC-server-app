package user;

import com.tc.streaming.grpc.User.APIResponse;
import com.tc.streaming.grpc.User.Empty;
import com.tc.streaming.grpc.User.LogInRequest;
import com.tc.streaming.grpc.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase {

	@Override
	public void login(LogInRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("inside login");
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response =  APIResponse.newBuilder();
		
		
		
		if(username.equalsIgnoreCase("Admin") && password.equalsIgnoreCase("password")){
			
			response.setResponsecode("200").setResponsemessage("login successful");
			
		}
		else {
			response.setResponsecode("400").setResponsemessage("use not found");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
		APIResponse.Builder response =  APIResponse.newBuilder();
		
		response.setResponsecode("200").setResponsemessage("logged out successfully");
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
		
	}

}
