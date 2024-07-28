package com.heg.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity //make the norml @configuration class spring security configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Build Authentication Manager by taking givn authentication info provider (InMemory DB)
	/*	auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").authorities("CUSTOMER");
		auth.inMemoryAuthentication().withUser("ramesh").password("{noop}ramesh").authorities("MANAGER"); */
		
	//	auth.inMemoryAuthentication().withUser("raja").password("$2a$10$JKR6WwscNaY5jyIkhoxNzuccxn/SwjFR.NIS8cSgkfZG0/E1K9E/y").authorities("CUSTOMER");
	//	auth.inMemoryAuthentication().withUser("ramesh").password("$2a$10$F532F9/wEV.FAakcWe5e8OQpDudpjgYg.G2qdwPdYSwVQ6WEFOA3m").authorities("MANAGER");
	//	auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$JKR6WwscNaY5jyIkhoxNzuccxn/SwjFR.NIS8cSgkfZG0/E1K9E/y").authorities("CUSTOMER");
	//	auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("ramesh").password("$2a$10$F532F9/wEV.FAakcWe5e8OQpDudpjgYg.G2qdwPdYSwVQ6WEFOA3m").authorities("MANAGER");
		
		//USING JDBC API
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder()).
		usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?") //THIS IS FOR AUTHENTICATION
		.authoritiesByUsernameQuery("SELECT UNAME,ROLES FROM USER_ROLES WHERE UNAME=?"); //THIS ARE FOR AUTHORIZATION
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/home").permitAll() //no authentication an not authorization
		.antMatchers("/offers").authenticated() //only authentication
		.antMatchers("/balance").hasAnyAuthority("CUSTOMER","MANAGER") //authenticaion and authorization MANGER+CUSTOMER
		.antMatchers("/loanApprove").hasAnyAuthority("MANAGER") //AUTHENTICTIOn and authorization MANAGER
		.anyRequest().authenticated() //remaining all request url must be authenmticaled		
		
		//specify authentication mode
		//.and().httpBasic()
		.and().formLogin()
		
		//add remeber me filter
		.and().rememberMe() //for 48 hours 
		
		
		//enabling logout		
		//.and().logout()
		
		//customize logount 
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("signout"))
		
		//exception / error handling		
		.and().exceptionHandling().accessDeniedPage("/access_denied")

		//add sessionMaxConcurrency count 
		.and().sessionManagement().maximumSessions(1)
		.maxSessionsPreventsLogin(true).expiredUrl("/timeout");
		
	}
}
