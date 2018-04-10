package client;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ENG-TORKY
 */
public class Client {

    public static void main(String[] args) {

        Socket clientServer = null;
        try {
            clientServer = new Socket("localhost", 9876);
            DataInputStream in = new DataInputStream(clientServer.getInputStream());
            DataOutputStream out = new DataOutputStream(clientServer.getOutputStream());

            System.out.println("please enter your message:");
            out.writeUTF(new Scanner(System.in).nextLine());

            String data = in.readUTF();
            System.out.println("Received: " + data);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } finally {
            if (clientServer != null) {
                try {
                    clientServer.close();
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
        }
    }

}
