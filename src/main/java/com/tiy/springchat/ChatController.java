package com.tiy.springchat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Brett on 9/23/16.
 */
@Controller
public class ChatController {

	@Autowired
	UserRepository users;

	@Autowired
	MessageRepository messages;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String home(HttpSession session, Model model) {
		return "home";
	}

	//map second path for when user exists
	@RequestMapping(path = "/newUser", method = RequestMethod.POST)
	public String newUser(HttpSession session, String userName, String password) {
		User user = users.findFirstByUserName(userName);
		if (user == null) {
			user = new User(userName, password);
			users.save(user);
		}
		return "redirect:/";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, String userName, String password) throws Exception {
		User user = users.findFirstByUserName(userName);
		if (user == null) {
			throw new Exception("User does not exist");
		} else if (!password.equals(user.getPassword())) {
			throw new Exception("Password is incorrect!");
		}
		session.setAttribute("user", user);
		return "redirect:/chat";
	}

	@RequestMapping(path = "/sendMessage", method = RequestMethod.POST)
	public String sendMessage(HttpSession session, String text) {
		User user = (User)session.getAttribute("user");
		Message msg = new Message(text, user);
		messages.save(msg);
		return "redirect:/chat";
	}

	@RequestMapping(path = "/chat", method = RequestMethod.GET)
	public String chat() {
		return "/chat";
	}
}
