package server;

import java.net.*;
import com.google.gson.Gson;

import java.io.*;
import message.*;

public class Send extends Thread {
	DataOutputStream out;
	Socket socket;
	

	public Send (Socket aClientSocket) {
	    try {
	    	socket = aClientSocket;
			out = new DataOutputStream( socket.getOutputStream());
			this.start();
	     } catch(IOException e)  {
	    	 System.out.println("Connection:"+e.getMessage());}
	}
	public void run(){
	    try {	
	    	System.out.println("Digite a sua mensagem e aperte enter para envia-la ou digite sair123 para sair do batepapo ");
	    	while (true) {
				
	              Gson gson = new Gson();
				BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));				  					
				Mensagem mensagem = new Mensagem( entrada.readLine());
				
				String saida = gson.toJson(mensagem);
				
				if(mensagem.conteudo.equals("sair123")) {
					socket.close();
					break;
				}
				
				  
				
				out.writeUTF( saida );				
	    	}                
	 
	    } catch(EOFException e) {System.out.println("EOF:"+e.getMessage());
	    } catch(IOException e) {System.out.println("IO:"+e.getMessage());
	    } finally{ try {socket.close();}catch (IOException e){/*close failed*/}}
	}
}
