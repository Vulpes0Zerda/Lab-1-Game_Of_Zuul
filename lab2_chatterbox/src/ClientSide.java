import java.net.*;
import java.io.*;

public class ClientSide {
    private Socket socket = null;
    private PrintWriter output = null;

    public ClientSide(String address, int port) {
        try {
            // Connect to the server
            socket = new Socket(address, port);
            System.out.println("Connected to the server");

            // Send "Hello" to the server
            output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello");

            // Close the connection
            System.out.println("Closing connection");
            socket.close();
            output.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new ClientSide("127.0.0.1", 5000);
    }
}
