package coderdojo.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * A client to connect to the DateServer
 * 
 * To use once compiled :
 * 
 * java -cp ./bin coderdojo.networking.DateClient
 * 
 */
public class DateClient {

    /**
     * Runs a client, prompts for the DateServers IP Address and 
     * then connects to it and displays the date that returns.
     */
    public static void main(String[] args) throws IOException {
    	
    	// Request the user to enter the IP Address of the Date Server
        String serverAddress = JOptionPane.showInputDialog("Enter IP Address of the date service on port 9090:");
        
        // Once we have the IP Address connect to it and get the date
        Socket s = new Socket(serverAddress, 9090);

        // Read in the data from the server
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        
        // Display the date
        JOptionPane.showMessageDialog(null, answer);
        
        // Finish up
        System.exit(0);
    }
}