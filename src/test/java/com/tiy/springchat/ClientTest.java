package com.tiy.springchat;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;
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

		//test works with server running in background
		myClient = new Client();
		myServer = new Server();
		User myUser = new User();
		Message myMessage = new Message();

		myUser.id = 100;
		myUser.userName = "Rick Sanchez";
		myUser.password = "abcdefg";
		myMessage.text = "This is a message, blah blah blah";
		myMessage.id = 100;
		myMessage.user = myUser;

		Thread myThread = new Thread(myServer);
		myThread.start();
//		Thread.sleep(3000);

		String jsonString = jsonSave(myMessage);
		myClient.newClientSocket();
		myClient.sendMessage(jsonString);

		String input = myClient.response;

		System.out.println(myServer.myMessages.size());


		assertEquals(1, myServer.myMessages.size());
		assertEquals(input, myMessage.text);



	}

	public String jsonSave(Message message) {
		JsonSerializer jsonSerializer = new JsonSerializer().deep(true);
		String jsonString = jsonSerializer.serialize(message);

		return jsonString;
	}


}