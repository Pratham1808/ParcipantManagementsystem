package com.participant.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.participant.dao.UserRepository;
import com.participant.entity.Signup;
import com.participant.helper.Message;



@Controller
public class UserController {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository repository;
	
	// handler for home
	@GetMapping("/")
	public String home() {
		return "home";
	}

	// handler for signup
	@GetMapping("/signup")
	public String Signup() {
		return "signup";
	}

	// handler for process_signup
	@PostMapping("/process_signup")
	public String processSignup(@Valid @ModelAttribute("signup") Signup signup, BindingResult result1, Model model,
			HttpSession session) {
		try {
			if (result1.hasErrors()) {
				System.out.println("ERROR" + result1.toString());
				model.addAttribute("signup", signup);
				return "signup";
			}
			signup.setRole("USER");
			signup.setPassword(passwordEncoder.encode(signup.getPassword()));
			Signup result = this.repository.save(signup);
			model.addAttribute("signup", new Signup());
			session.setAttribute("message", new Message("Successfully Registered!!", "alert-success"));
			return "signup";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("signup", signup);
			session.setAttribute("message", new Message("Somthing went wrong!!" + e.getMessage(), "alert-danger"));
			return "signup";
		}
	}

	// handler for login
	@GetMapping("/signin")
	public String login() {
		return "login";
	}
	

}
