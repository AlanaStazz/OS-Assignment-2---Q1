//OS Ass 2 - Q1 - Server
//Alana Staszczyszyn & Elijah Tavenor
//October 19, 2017

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class EchoClient {

    public static void main(String args[]){
        String msg = "";

	//Error Checking
        if(args.length < 1){
            System.err.println("Error: Too Few Args");
            System.err.println("Usage: EchoClient <ip> ");
            System.exit(2);
        }else if(args.length > 1){
            System.err.println("Error: Too Many Args");
            System.err.println("Usage: EchoClient <ip> ");
            System.exit(2);
        }

        try{
            while(!msg.equals(".")) {
            //Create new socket
            Socket sock = new Socket(args[0],666);

            //Create Input Stream
            BufferedInputStream inStream =  new BufferedInputStream(sock.getInputStream());

            //Create output stream, auto flush buffer
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);

            //Create scanner for input and variable for storage
            Scanner scan = new Scanner(System.in);


                System.err.println("\nEnter a message: ");
                msg = scan.nextLine();

                //Write the data to the output stream
                pout.println(msg);

                //Read the data from the input stream (server)
                int data = inStream.read();

                //Print data
		//System.err.println("");
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

