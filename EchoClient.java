/*
Assignment 2: Question #1
Bikramjit Garcha (991330905)
Harmanjeet Singh (991439186)
*/


import java.net.*;
import java.io.*;

public class EchoClient
{
	public static void main(String[] args) {
		try {
			/* make connection to server socket */
			Socket sock = new Socket("127.0.0.1",6013);

			BufferedReader read = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			BufferedReader connection = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(sock.getOutputStream(), true); 
			

			/* Reads user input from the client and stores it into PrintWriter which than sends it
			   to the OutputStream which is than printed by the client */

			String input;

			do {

				input = read.readLine();
				if ( input != null )
					System.out.println(input);
				input = connection.readLine();
				writer.println(input);
			}
			while (!input.trim().equals("."));
			/* close the socket connection*/
		}		
		catch (IOException ioe) {
		System.err.println(ioe);
		}
	}
}
