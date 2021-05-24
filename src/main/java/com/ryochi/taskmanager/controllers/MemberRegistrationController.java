package com.ryochi.taskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ryochi.taskmanager.entities.MemberRegistration;
import com.ryochi.taskmanager.entities.MemberRegistrationForm;
import com.ryochi.taskmanager.services.RegisterMemberService;

@Controller
public class MemberRegistrationController {
	
	@Autowired
	private RegisterMemberService registMemberService;
	
	@RequestMapping(value="/RegistrationForm")
	public String showRegistMemberForm(Model model) {
		model.addAttribute(new MemberRegistrationForm());
		return "RegistrationForm";
	}
	
	@RequestMapping("/Register")
	public String registerUser(@ModelAttribute  MemberRegistrationForm memberRegistrationForm) {
		MemberRegistration entity = new MemberRegistration();
		entity.setUserName(memberRegistrationForm.getUserName());
		entity.setPassword(memberRegistrationForm.getPassword());
		registMemberService.registermemeber(entity);
		return "Result";
	}
}
	

