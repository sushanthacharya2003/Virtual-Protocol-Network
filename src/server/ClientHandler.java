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
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try {
                clientSocket.close();
            } catch(IOException e){
                e.printStackTrace();

            }
        }
    }
    public static void main(String Args[]){
        try {
            VPNClient client = new VPNClient();
            client.start();
        }catch(IOException e){
            e.printStackTrace();
        }
    }