import java.net.*;
import java.io.*;

public class ServerSide {
    private Socket socket = null;
    private ServerSocket server = null;
    private BufferedReader in = null;

    public ServerSide(int port) {
        // Step 1 task 1
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = "";
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
            }

            System.out.println("Closing connection");
            socket.close();
            in.close();
        } catch(IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new ServerSide(5000);
    }
}
