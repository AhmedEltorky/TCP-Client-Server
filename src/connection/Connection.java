package connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author ENG-TORKY
 */
public class Connection extends Thread {

    private Socket clientSocet;
    private DataInputStream in;
    private DataOutputStream out;

    public Connection(Socket clientSocet) {
        try {
            this.clientSocet = clientSocet;
            in = new DataInputStream(this.clientSocet.getInputStream());
            out = new DataOutputStream(this.clientSocet.getOutputStream());
            this.start();
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    @Override
    public void run() {
        try {
            // echo server
            String data = in.readUTF();
            out.writeUTF(data);
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } finally {
            if (this.clientSocet != null) {
                try {
                    this.clientSocet.close();
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                }
            }
        }
    }

}
