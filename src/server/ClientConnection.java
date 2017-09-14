package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ClientConnection implements Runnable {

    private Socket s;

    public ClientConnection(Socket s) throws SocketException, IOException {
        this.s = s;
    }

    @Override
    public void run() {
     try {
         try{
             InputStream input = s.getInputStream();
             OutputStream output = s.getOutputStream();

             Scanner in = new Scanner(input);

             PrintWriter out = new PrintWriter(output,true);

             out.println("Velkommen");

             boolean done = false;
             while(!done && in.hasNextLine()) {
                 String stream = in.nextLine();
                 if(stream.equals("luk ned")) {
                     done = true;
                 } else {
                     out.println(stream);
                 }
             }
         }
         finally {
             s.close();
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
    }
}
