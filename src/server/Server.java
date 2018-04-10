package server;

import connection.Connection;
import java.net.*;
import java.io.*;

/**
 *
 * @author ENG-TORKY
 */
public class Server {

    public static void main(String[] args) {
        
        System.out.println("TCP Server running....");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9876);
            while (true) {
                Socket clientServer = serverSocket.accept();
                Connection connection = new Connection(clientServer);
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

}
