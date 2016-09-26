package com.tiy.springchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brett on 9/25/16.
 */
public class Client {

	String response;

	public void startClient(String chatString) {

//        Scanner inputScanner = new Scanner(System.in);
		try {
			// connect to the server on the target port
			Socket clientSocket = new Socket("localhost", 8005);

			// once we connect to the server, we also have an input and output stream
			PrintWriter outputToServer = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

//            System.out.println("Enter your message to send: ");
			String userMessage = chatString;
			outputToServer.println(userMessage);
			response = inputFromServer.readLine();
			System.out.println(response);

			// close the connection
			clientSocket.close();


		} catch (IOException clientException) {
			clientException.printStackTrace();
		}

	}
}
