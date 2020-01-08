package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ericyao.tollway.server.entity.Gate;
import dev.ericyao.tollway.server.service.GateService;

@Controller
@RequestMapping("/gate")
public class GateController {

	@Autowired
	GateService gService;
	
	@GetMapping
	public String displayGates(Model model) {
		Iterable<Gate> gates = gService.getGates();
		model.addAttribute("gates", gates);
		
		System.out.println("gate added to model");
		return "gate/gate-list";
	}
	
}
