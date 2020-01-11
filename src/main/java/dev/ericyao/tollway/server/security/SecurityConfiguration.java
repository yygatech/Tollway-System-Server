package dev.ericyao.tollway.server.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.usersByUsernameQuery("select username, password, enabled "
					+ "from user_account where username = ?")
			.authoritiesByUsernameQuery("select username, role "
					+ "from user_account where username = ?")
			.dataSource(dataSource)
			.passwordEncoder(bCryptEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/gate/new").hasRole("ADMIN")
			.antMatchers("/gate/save").hasRole("ADMIN")
			.antMatchers("/vehicle/new").hasRole("ADMIN")
			.antMatchers("/vehicle/save").hasRole("ADMIN")
			.antMatchers("/", "/**").permitAll()
			.and()
			.formLogin()
			.and()
			.logout().logoutSuccessUrl("/");
	}
}
