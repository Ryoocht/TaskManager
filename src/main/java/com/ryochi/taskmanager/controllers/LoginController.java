package com.ryochi.taskmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	//Login Form transition
	@RequestMapping("/login")
	public String showLoginForm(Model model) {
		return "login";
	}
	
	@RequestMapping("/")
	public String login(Model model) {
		return "todo";
	}
}
