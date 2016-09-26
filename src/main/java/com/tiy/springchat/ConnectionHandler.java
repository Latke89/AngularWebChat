package com.tiy.springchat;

import jodd.json.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Brett on 9/25/16.
 */
public class ConnectionHandler implements Runnable {

	Socket connection;
	Server myServer;

	public ConnectionHandler(Socket incomingConnection, Server myServer) {
		this.connection = incomingConnection;
		this.myServer = myServer;
	}

	public void run() {
		handleIncomingConnections(connection);
	}


	private void handleIncomingConnections(Socket inputSocket) {
		try {
			System.out.println("Incoming connection from " + inputSocket.getInetAddress().getHostAddress());

			BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
			PrintWriter outputToClient = new PrintWriter(inputSocket.getOutputStream(), true);

//			String firstInput;
//			String clientName;
//			firstInput = inputFromClient.readLine();
//			String[] nameArray = firstInput.split("=");
//			clientName = nameArray[1];
//			outputToClient.println("Thank you, " + clientName);


			String inputLine;
			while((inputLine = inputFromClient.readLine()) != null) {
				System.out.println("Received message \"" + inputLine + "\" from " + connection.toString());
				Message currentMessage = jsonRestore(inputLine);
				String messageContent = currentMessage.user.userName + " said: " + currentMessage.text;
				myServer.saveMessage(messageContent);
				for (String message : myServer.myMessages) {
					outputToClient.println(message);
				}
				outputToClient.println("TXT::DONE");
			}

		}catch (IOException exception){
			exception.printStackTrace();
		}
	}

	public Message jsonRestore(String jsonTD) {
		JsonParser toDoItemParser = new JsonParser();
		Message message = toDoItemParser.parse(jsonTD, Message.class);

		return message;
	}


}
