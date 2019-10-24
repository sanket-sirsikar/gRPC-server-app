import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.UserService;

public class GRPCServer {

	public static void main(String[] args) throws InterruptedException {

		Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();

		try {
			server.start();
			System.out.println("listening on port 9090");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			server.awaitTermination();
			System.out.println("terminated server on port 9090");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
