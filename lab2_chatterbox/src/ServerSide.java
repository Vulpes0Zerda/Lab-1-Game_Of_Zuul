import java.net.*;
import java.io.*;

public class ServerSide {
    private Socket socket = null;
    private ServerSocket server = null;
    private BufferedReader input = null;

    public ServerSide(int port) {
        // Step 1 task 1
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = "";
            while ((line = input.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            System.out.println("Closing connection");
            socket.close();
            input.close();
        } catch(IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new ServerSide(5000);
    }
}
