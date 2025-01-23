package client;
import java.io.*;
import java.net.*;

public class VPNClient {
    private static final String SERVER_IP="127.0.0.1";
    private static final int PORT=12345;
    private Socket socket;

    public VPNClient() throws IOException{
        socket=new Socket(SERVER_IP,PORT);
        System.out.println("Connected to VPN Server at " + SERVER_IP + ":" + PORT);
    }
    public void start(){
        try(BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream())))
            PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {
            String userMessage;
            while(True){
                System.out.print("Enter a message to send (or 'exit')to quit");
                userMessage = userInput.readLine();
            }
        }
}
