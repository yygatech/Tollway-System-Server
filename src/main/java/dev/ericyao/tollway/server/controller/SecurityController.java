package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dev.ericyao.tollway.server.entity.UserAccount;
import dev.ericyao.tollway.server.service.UserAccountService;

@Controller
public class SecurityController {
	
	@Autowired
	UserAccountService uaService;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@GetMapping("/register")
	public String register(Model model) {
		UserAccount userAccount = new UserAccount();
		model.addAttribute("userAccount", userAccount);
		
		return "security/register";
	}
	
	@PostMapping("/register/save")
	public String saveUser(UserAccount userAccount, Model model) {
		System.out.println("/register/save received");
		userAccount.setPassword(bCryptEncoder.encode(userAccount.getPassword()));
		uaService.saveUserAccount(userAccount);
		
		return "redirect:/";
	}
	
	@GetMapping("/encrypt")
	public String encyptUnencrypted() {
		uaService.encryptUnencryptedUserAccounts();
		
		return "redirect:/";
	}
	
}
