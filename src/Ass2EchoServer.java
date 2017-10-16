//OS Ass 2 - Q1 - Server
//Alana Staszczyszyn & Elijah Tavenor
//October 19, 2017

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ass2EchoServer {

    public static void main(String args[]){

        try{

            //Make new socket
            ServerSocket sock = new ServerSocket(666);

            //While listening...
            while(true){

                //Accept an attempt and call it client
                Socket client = sock.accept();

                //Name client's input stream
                InputStream inStream = client.getInputStream();

                //Name client's output stream, enable auto buffer flush
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                //Print prompt
                String msg = "\nServer: ";
                System.out.println(msg);

                //Grab data from the input stream
                int data = inStream.read();

                //While it's not a newline (i.e. not end of data stream)...
                while(data != 10){

                    //Keep appending, reading next data, and printing
                    msg += ((char) data);
                    data = inStream.read();
                    System.out.println(data);
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
