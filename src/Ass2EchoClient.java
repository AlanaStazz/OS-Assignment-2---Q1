//OS Ass 2 - Q1 - Server
//Alana Staszczyszyn & Elijah Tavenor
//October 19, 2017

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Ass2EchoClient {

    public static void main(String args[]){

        try{

            //Create new socket
            Socket sock = new Socket("127.0.0.1",666);

            //Instantiate new object that extends InputStream
            ExtendInputStream inStream = new ExtendInputStream(sock.getInputStream());

            //Name the output stream, enable auto buffer flush
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);

            //Prompt
            System.out.println("Enter a string:");
            Scanner scan = new Scanner(System.in);

            //Maybe loop for nice usability?
            //  do {


            //Write the input to the output stream
            String msg;
            msg = scan.nextLine();
            pout.println(msg);

            //Read the data back from the input stream (from the server) and print it
            int data = inStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = inStream.read();
            }

            // System.out.println("Enter a string. Enter '0' to terminate.");
            //  Scanner scan = new Scanner(System.in);

            // }while(scan != '0');
            sock.close();
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
    }

    }
}
