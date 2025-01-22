package server;

import java.io.*;
import java.net.*;


public class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }
}
    public void run(){
        try(BufferedReader in=new BufferedReader(new InputStreamReader(clientSocket.getInputStream)));
            PrintWriter out=new PrintWriter(clientSocket.getOutputStream(),true)){
            String received;
            while((received=in.readLine()))!=null){
            System.out.println("Received"+received);
            }
        }
    }