package com.tiy.springchat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Brett on 9/23/16.
 */
public class ConnectionHandler implements Runnable {

//	Socket connection = null;
//	ArrayList<String> messageHistory;
//
//	public ConnectionHandler (Socket incomingConnection) {
//		this.connection = incomingConnection;
////        this.messageHistory = messageHistory;
//	}
//
//	public ConnectionHandler () {
//	}
//
	public void run() {
//		try {
//			handleIncomingConnection(connection);
//		} catch (Exception exception) {
//			exception.printStackTrace();
//		}
	}
//
//	public void handleIncomingConnection (Socket clientSocket) throws Exception {
//		System.out.println("Connection accepted");
//
//		// this is how we read from the client
//		BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
//		// this is how we write back to the client
//		PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
//
//		String inputLine = inputFromClient.readLine();
//		if (!inputLine.equals("return:history")) {
//			myDatabase.postMessage(myDatabase.conn, inputLine);
//		}
//
//		messageHistory = myDatabase.chatHistory(myDatabase.conn);
//		for (String currentString : messageHistory) {
//			outputToClient.println(currentString);
//		}
//		outputToClient.println("end:history");
//	}
}
