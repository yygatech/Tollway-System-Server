package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ericyao.tollway.server.dto.DetailedTransaction;
import dev.ericyao.tollway.server.service.TransactionService;

@Controller
@RequestMapping(value = {"/", "/transaction"})
public class TransactionController {

	@Autowired
	TransactionService tService;
	
	@GetMapping
	public String displayDetailedTransactions(Model model) {
		Iterable<DetailedTransaction> detailedTransList = tService.getDetailedTransactions();
		model.addAttribute("detailedTransactions", detailedTransList);
		
		return "transaction/transaction-list";
	}
	
}
