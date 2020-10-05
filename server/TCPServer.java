package server;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class TCPServer {
	public static void main(String argv[]) throws Exception {
		try {

			ServerSocket servidor = new ServerSocket(5000);
			while (true) {
				Socket conexao = servidor.accept();

				Receive in = new Receive(conexao);
				
				Send out = new Send(conexao);

			}
		} catch (IOException e) {
			System.out.println("Escuta: " + e.getMessage());
		}
	}
}

