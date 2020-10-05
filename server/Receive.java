package server;

import java.net.*;

import com.google.gson.Gson;

import java.io.*;
import message.*;
public class Receive extends Thread {
	DataInputStream in;
	Socket socket;

	public Receive(Socket aClientSocket) {
		try {
			socket = aClientSocket;
			in = new DataInputStream(socket.getInputStream());
			this.start();
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
	    		System.out.println("\nRecebido do usuario 1: " + msg.getConteudo());
	    		
	    	}
	    } catch(EOFException e) {System.out.println("EOF:"+e.getMessage());
	    } catch(IOException e) {System.out.println("IO:"+e.getMessage());
	    } finally{ try {socket.close();}catch (IOException e){/*close failed*/}}
	}
}