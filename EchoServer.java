/*
Assignment 3: Question #2
Bikramjit Garcha (991330905)
Harmanjeet Singh (991439186)
*/

import java.net.*;
import java.io.*;
public class EchoServer {

	public static class Echo implements Runnable{
		BufferedReader read;
		PrintWriter writer;
		String input;
		Socket client;

		public Echo(Socket client) {
			try{
				this.client = client;
				this.read = new BufferedReader(new InputStreamReader(client.getInputStream()));
				this.writer = new PrintWriter(client.getOutputStream(), true);
				this.input = "\nServer:\n";
				System.out.println(input);
			} catch(IOException e){
                		System.out.println(e);
            		}
		}
		
		public void exec(){
			try{
				writer.println("welcome to the Echoserver. Type '.' to end ");
				
				/* Gets user input from the client and stores it into PrintWriter which than sends it to the OutputStream */

				do {
					input = read.readLine();
				if ( input != null )
					writer.println("Server:" + input);
				}
				while (!input.trim().equals(".")); // close the socket when '.' is entered

				System.out.println("connection closed");
				client.close();	
			}catch(IOException e){
				System.out.println(e);
			}	
		}

		public void run() {
			exec();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			// make new socket
			ServerSocket sock = new ServerSocket(6016); //creates new socket at the specified portnumber 
			Echo server;
			
			/* listens for connections */

			while (true) {
				//made thread using a socket
				server= new Echo(sock.accept());
				new Thread(server).start();
				System.out.println("connection opened");
			}
		}
		catch (IOException ioe) {
			System.err.println(ioe);
		}
	}
}
