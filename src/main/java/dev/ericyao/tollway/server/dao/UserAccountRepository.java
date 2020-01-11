package dev.ericyao.tollway.server.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import dev.ericyao.tollway.server.entity.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
	
	@Query(nativeQuery = true,
			value = "SELECT * " + 
					"FROM user_account " + 
					"WHERE password NOT SIMILAR TO '$2[aby]$%'")
	public Iterable<UserAccount> getUnencryptedUserAccounts();
	
	public UserAccount findByUsername(String username);
	
	public UserAccount findByEmail(String email);
}
