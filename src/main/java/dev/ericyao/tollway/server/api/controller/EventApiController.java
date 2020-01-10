package dev.ericyao.tollway.server.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ericyao.tollway.server.entity.Transaction;
import dev.ericyao.tollway.server.object.Event;
import dev.ericyao.tollway.server.service.EventService;

@RestController
@RequestMapping("/api/event")
public class EventApiController {
	
	@Autowired
	EventService eService;
	
	@PostMapping(consumes = "application/json")
	public Transaction processEvent(@RequestBody Event event) {
		return eService.processEvent(event);
	}
}
