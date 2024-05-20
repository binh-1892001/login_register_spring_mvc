package com.ra.login_register.controller;

import com.ra.login_register.dto.request.FormRegister;
import com.ra.login_register.dto.request.FormLogin;
import com.ra.login_register.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

	@GetMapping("/")
	public String login(Model model) {
		model.addAttribute("formLogin",new FormLogin());
		return "login";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("formRegister",new FormRegister());
		return "register";
	}
	
	@GetMapping("/login")
	public String handleLogin(@ModelAttribute("formLogin") FormLogin formLogin,HttpSession session) {
		session.setAttribute("user",Users.builder().id(1L).fullName("bình").build());
		return "home";
	}
	
	@PostMapping("/register")
	public String handleRegister(@ModelAttribute("formRegister") FormRegister formRegister) {
		return "login";
	}

}
