//OS Ass 2 - Q1 - Server
//Alana Staszczyszyn & Elijah Tavenor
//October 19, 2017

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ass2EchoServer {

    public static void main(String args[]){
            Boolean on = true;
        try{

            //Make new socket
            ServerSocket sock = new ServerSocket(666);

            //While listening...
            while(on){

                //Listen for attempted connection
                Socket client = sock.accept();

                //Create client input stream
                InputStream inStream = client.getInputStream();

                //Create output stream
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                //Print server prompt
                String msg = "\nServer: ";
                System.out.println(msg);

                //Grab data from the input stream
                int data = inStream.read();

                //If the kill signal was received, terminate server
                if(data == 48)
                    break;

                //While it's not a newline (i.e. not end of data stream)
                while(data != 10){

                    //Keep appending, reading next data, and printing
                    System.out.println(data + " " + (char) data);
                    msg += ((char) data);
                    data = inStream.read();
                }

                //Print the data to the output stream
                pout.println(msg);

                //End the session
                client.close();
            }
        }
        catch (IOException ioe){
            System.err.println(ioe);
        }
    }
}
