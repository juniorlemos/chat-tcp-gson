package client;

import java.net.*;
import java.io.*;
import com.google.gson.*;
import message.*;

public class Receive extends Thread {
	DataInputStream in;
	Socket socket;

	public Receive(Socket aClientSocket) {
		try {
			socket = aClientSocket;
			in = new DataInputStream(socket.getInputStream());
			
		} catch (IOException e) {
			System.out.println("Connection:" + e.getMessage());
		}
	}

	public void run(){
	    try {			                 // an echo server
	    	while(true) {
	    		String resposta = in.readUTF();
	    		Gson gson = new Gson();
	    		Mensagem msg = gson.fromJson(resposta, Mensagem.class);
	    		System.out.println("\nRecebido do usuario 2: " + msg.getConteudo());
	    		
	    	}
	    } catch(EOFException e) {System.out.println("EOF:"+e.getMessage());
	    } catch(IOException e) {System.out.println("IO:"+e.getMessage());
	    } finally{ try {socket.close();}catch (IOException e){/*close failed*/}}
	}
}