package com.tiy.springchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brett on 9/23/16.
 */

@RestController
public class ChatRestController {
	@Autowired
	MessageRepository messages;

	@RequestMapping(path = "/messages.json", method = RequestMethod.GET)
	public List<Message> getMessages() {
		Iterable <Message> msgIterable =  messages.findAll();
		ArrayList<Message> msgList = new ArrayList<>();
		for (Message msg : msgIterable) {
			msgList.add(msg);
		}
		return msgList;
	}

	@RequestMapping(path = "/sendMessage.json", method = RequestMethod.POST)
	public List<Message> sendMessage(HttpSession session, @RequestBody Message message) throws Exception {
		User user = (User)session.getAttribute("user");
		if(user == null) {
			throw new Exception("User must be logged in to send messages");
		}
		message.user = user;
		messages.save(message);

		return getMessages();
	}
}