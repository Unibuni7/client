package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Server {

    public static void main(String[] args){

        ServerSocket ss;
        try
        {
        //ServerSocket oprettes og port 8001 angives som den der skal lyttes på
        ss = new ServerSocket(8001);

        System.out.println("Server kører...");
        while(true) {
            // så længe der ikke er oprettet en forbindelse, venter serveren her
            //så snart der anmodes om en forbindelse accepteres den med accept()
            Socket incoming = ss.accept();
            System.out.println("Klient forbundet");

            Runnable r = new ClientConnection(incoming);
            Thread t = new Thread(r);
            t.start();
        }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

}
