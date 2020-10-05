package client;

import java.net.*;
import java.io.*;

public class TCPClient {


	public static void main(String args[]) {

		Socket socket = null;
		try {
			
			socket = new Socket("127.0.0.1", 5000);

			Receive in = new Receive(socket);
			in.start();
			
			Send out = new Send(socket);
			out.start();			
			out.join();
			

		} catch (UnknownHostException e) {
			System.out.println("Sock:" + e.getMessage());
		} catch (EOFException e) {
			System.out.println("EOF: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("IN: " + e.getMessage());
		} finally {
			if ( socket != null) {
				try {
					 socket.close();
				} catch (IOException e) {
					System.out.println("close:" + e.getMessage());
				}
			}
		}
	}
}