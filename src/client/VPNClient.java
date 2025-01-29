package client;

import java.io.*;
import java.net.*;

public class VPNClient {
    private static final String SERVER_IP = "127.0.0.1"; // Change if you're connecting to a remote server
    private static final int PORT = 12345;
    private Socket socket;

    public VPNClient() throws IOException {
        socket = new Socket(SERVER_IP, PORT);
        System.out.println("Connected to VPN Server at " + SERVER_IP + ":" + PORT);
    }

    public void start() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            String userMessage;
            while (true) {
                System.out.print("Enter message to send (or 'exit' to quit): ");
                userMessage = userInput.readLine();
                if ("exit".equalsIgnoreCase(userMessage)) {
                    break;
                }
                out.println(userMessage);
                System.out.println("Server replied: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            VPNClient client = new VPNClient();
            client.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}