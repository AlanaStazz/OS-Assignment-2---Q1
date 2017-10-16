//OS Ass 2 - Q1 - Server
//Alana Staszczyszyn & Elijah Tavenor
//October 19, 2017

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Ass2EchoClient {

    public static void main(String args[]){

        try{

            while(true){

                //Create new socket
                Socket sock = new Socket("127.0.0.1",666);

                //Create Input Stream
                InputStream inStream = sock.getInputStream();

                //Create output stream, auto flush buffer
                PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);

                //Create scanner for input and variable for storage
                Scanner scan = new Scanner(System.in);
                String msg;

                //Prompt for and accept
                System.out.println("Enter a string. Enter '0' to terminate.");
                msg = scan.nextLine();

                //Write the data to the output stream
                pout.println(msg);

                //If the kill signal was sent, terminate client
                if(msg.equalsIgnoreCase("0"))
                    break;

                //Read the data from the input stream (server)
                int data = inStream.read();

                //Print data
                while (data != -1) {
                    System.out.print((char) data);
                    data = inStream.read();
                }

                //End the session
                sock.close();
            }
        }
        catch(IOException ioe){
            System.err.println(ioe);
        }
    }
}

