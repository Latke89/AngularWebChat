package com.tiy.springchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Created by Brett on 9/23/16.
 */
public class Server {


//	public static void main(String[] args) {
//		Server myServer = new Server();
//		myServer.kickThingsOff();
//	}
//
//	public void kickThingsOff() {
//		try {
//			System.out.println("Running...");
//
//			startServer();
//		} catch(SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	Socket connection = null;
//
//	public Server () {}
//
//	public Server (Socket connection) {this.connection = connection;}
//
//	public void startServer() {
//		try {
//			System.out.println("Starting Server");
//			ServerSocket listener = new ServerSocket(8088);
//
//			while(true) {
//				Socket incConnection = listener.accept();
//				ConnectionHandler handler = new ConnectionHandler(incConnection, myDatabase);
//				Thread multiThreadServer = new Thread(handler);
//
//				multiThreadServer.start();
//			}
//		} catch (IOException ex) {
//			ex.printStackTrace();
//		}
//	}
}
