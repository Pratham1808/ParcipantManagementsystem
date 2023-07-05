package com.participant.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.participant.dao.ResultRepository;
import com.participant.dao.UserRepository;
import com.participant.entity.Participant;
import com.participant.entity.Signup;
import com.participant.service.ParticipantService;

@Controller
@RequestMapping("/user")
public class ResultController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ResultRepository resultRepository;
	@Autowired
	private ParticipantService service;

	// handler for result
	@GetMapping("/result")
	public String result() {
		return "normal/result";
	}

	// handler for process_result
	@PostMapping("/process-result")
	public String process_result(@ModelAttribute("participant") Participant pariticipant, Model model,
			Principal principal) {
		service.calculateScore(pariticipant);
		resultRepository.save(pariticipant);
		return "normal/result-page";
	}

	//handler for show result
	@GetMapping("/{id}/result_list")
	public String showResult(@PathVariable("id") Integer id,Model m, Principal principal) {
		System.out.println(id);
		Optional<Participant> participantopt = this.resultRepository.findById(id);
		Participant participant = participantopt.get();
		m.addAttribute("participant",participant);
		return "normal/result_list";
	}
}
