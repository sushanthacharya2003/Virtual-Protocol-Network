package server;
import java.io.*;
import java.net.*;

public class VPNServer(){
    private static final int PORT=12345;
    private ServerSocket serverSocket;

    public VPNServer() throws IOException{
        serverSocket=new ServerSocket(PORT);
        System.out.println("the VPN sever is running at port "+PORT);
    }
    public void start(){
        while (true){
            try{
               Socket clientSocket=serverSocket.accept();
               System.out.println("Client Connected"+clientSocket.getInetAddress());
               new ClientHandler(clientSocket).start();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        try{
            VPNServer server=new VPNServer();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}