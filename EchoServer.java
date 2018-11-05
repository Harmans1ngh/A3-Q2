/*
Assignment 2: Question #1
Bikramjit Garcha (991330905)
Harmanjeet Singh (991439186)
*/

import java.net.*;
import java.io.*;
public class EchoServer
{
	public static void main(String[] args) {
		try {
			ServerSocket sock = new ServerSocket(6013); //creates new socket at the specified portnumber 
			
			/* listens for connections */

			while (true) {

				Socket client = sock.accept();
				System.out.println("connection opened");

				BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter writer = new PrintWriter(client.getOutputStream(), true);  
				writer.println("welcome to the Echoserver. Type '.' to end ");
				
				/* Gets user input from the client and stores it into PrintWriter which than sends it
			           to the OutputStream */

				String input;
				do {
					input = read.readLine();
					if ( input != null )
						writer.println("Server:" + input);
				}
				while (!input.trim().equals(".")); // close the socket when '.' is entered

				System.out.println("connection closed");
				client.close();
			}
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
