package coderdojo.networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * This class creates a TCP server that runs on port 9090.
 * 
 * When a client connects, it sends the client the current date and time
 * and closes the connection to that client.
 * 
 */
public class DateServer {

    /**
     * Runs the server using
     * 
     * java -cp ./bin coderdojo.networking.DateServer
     */
    public static void main(String[] args) throws IOException {
    	
    	// Create the socket server listening on port 9090
        ServerSocket listener = new ServerSocket(9090);
        
        // Print out some debug information
        System.out.println("Starting ServerSocket listening on port 9090");
        
        try {
        	
            while (true) {
            
            	// This socket wait until a client connects
            	Socket socket = listener.accept();
                
            	// Print out some debug information
                System.out.println("A new client has connected.");
            	
            	try {
            		
            		// Get the current server date and send it to the client.
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                } 
                finally {
                	
                	// Close the connection to the client
                    socket.close();

                    // Print out some debug information
                    System.out.println("Sent client information and closed connection");

                }
            }
        }
        finally {
        	
        	// Stop listening
            listener.close();
        }
    }
}