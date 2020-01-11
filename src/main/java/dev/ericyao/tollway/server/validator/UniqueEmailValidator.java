package dev.ericyao.tollway.server.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import dev.ericyao.tollway.server.dao.UserAccountRepository;
import dev.ericyao.tollway.server.entity.UserAccount;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	
	@Autowired
	UserAccountRepository uaRepo;
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		System.out.println("Entered validation method..");
		
		UserAccount ua = uaRepo.findByEmail(email);
		
		if (ua == null) {
			return true;
		} else {
			return false;
		}
	}
	
}
