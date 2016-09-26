package com.tiy.springchat;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Brett on 9/25/16.
 */
public class Server implements Runnable {

	public static void main(String[] args) {
		Server myServer = new Server();
		myServer.startServer();
	}

	public void run() {

	}


	public void startServer() {
		try {
			ServerSocket serverListener = new ServerSocket(8005);
			System.out.println("Ready to accept incoming connections!");

			while(true){
				Socket clientSocket = serverListener.accept();
				ConnectionHandler myHandler = new ConnectionHandler(clientSocket);
				Thread myThread = new Thread(myHandler);
				myThread.start();
			}



		}catch(IOException serverException){
			serverException.printStackTrace();
		}

	}

}
