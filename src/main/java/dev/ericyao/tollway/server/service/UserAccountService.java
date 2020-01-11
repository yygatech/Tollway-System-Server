package dev.ericyao.tollway.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.dao.UserAccountRepository;
import dev.ericyao.tollway.server.entity.UserAccount;

@Service
public class UserAccountService {
	
	@Autowired
	UserAccountRepository uaRepo;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	public Iterable<UserAccount> getUserAccounts() {
		return uaRepo.findAll();
	}
	
	public UserAccount saveUserAccount(UserAccount ua) {
		System.out.println("save user account to db");
		return uaRepo.save(ua);
	}
	
	public int encryptUnencryptedUserAccounts() {
		Iterable<UserAccount> uas = uaRepo.getUnencryptedUserAccounts();
		int count = 0;
		for (UserAccount ua: uas) {
			ua.setPassword(bCryptEncoder.encode(ua.getPassword()));
			
//			System.out.println("encrypted ua is: " + ua.toString());
			count++;
		}
		uaRepo.saveAll(uas);
		
		System.out.println(count + " user accounts have been encrypted.");
		return count;
	}
	
}
