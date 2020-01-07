package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ericyao.tollway.server.Server;

@RestController
@RequestMapping("/server")
public class ServerMainApiController {
	
	@Autowired
	Server server;
	
	@GetMapping
	public String processRequest() {
		return "";
	}
}
