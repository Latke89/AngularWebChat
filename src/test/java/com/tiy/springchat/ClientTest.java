package com.tiy.springchat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Brett on 9/25/16.
 */
public class ClientTest {

	@Autowired
	MessageRepository messages;

	@Autowired
	UserRepository users;

	Client myClient;
	Server myServer;

	@Before
	public void setUp() throws Exception {


	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void sendMessage() throws Exception {
		myClient = new Client();
		myServer = new Server();

//		Thread myThread = new Thread(myServer);
//		myThread.start();

		String message = "This is a message, blah blah blah";

		myClient.startClient(message);

		String input = myClient.response;


		assertEquals(input, message);

	}

}