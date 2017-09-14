package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args)
    {
        try {
            Socket s = new Socket("127.0.0.1", 8001);

            while (true) {
                InputStream input = s.getInputStream();
                OutputStream output = s.getOutputStream();

                Scanner in = new Scanner(input);

                PrintWriter out = new PrintWriter(output, true);

                String welcome = in.nextLine();
                out.println("Welcome");

                //nu kan vi så sende og modtage respektivt
                out.println("Først besked");
                // Vi udksriver nu bare direkte
                System.out.println(in.nextLine());

                out.println("Anden besked");
                // Vi udskriver nu bare direkte
                System.out.println(in.nextLine());

                out.println("Tredie besked");
                // Vi udksriver nu bare direkte
                System.out.println(in.nextLine());

                //Denne gang lukker vi selv forbindelsen. Fordi vi kan.
                //Vi kunne også have brugt "luk ned"
                s.close();
                System.out.println("Forbindelsen lukket.");

            }
        }
        catch (IOException ex) {
            // We ignore this.
        }
    }
}
