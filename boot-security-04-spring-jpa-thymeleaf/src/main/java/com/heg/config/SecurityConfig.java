package com.heg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // make the norml @configuration class spring security configuration class
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(service).passwordEncoder(encoder);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
				.antMatchers("/bank/home").permitAll() // no authentication an not authorization
				.antMatchers("/user/add").permitAll()
				.antMatchers("/user/show_login").permitAll()
				.antMatchers("/bank/offers").authenticated() // only authentication
				.antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER", "MANAGER") // authenticaion and authorization
																						// MANGER+CUSTOMER
				.antMatchers("/bank/loanApprove").hasAnyAuthority("MANAGER") // AUTHENTICTIOn and authorization MANAGER
				.anyRequest().authenticated() // remaining all request url must be authenmticaled

				// specify authentication mode
				// .and().httpBasic()
				.and().formLogin()
				.defaultSuccessUrl("/bank/", true) //home page url
				.loginPage("/user/show_login")  //for GET mode request for launch form page
				.loginProcessingUrl("/login") //for post mode request to submit and process the request
				.failureUrl("/user/show_login?error") //authentication fail url 
				

				// add remeber me filter
				.and().rememberMe() // for 48 hours

				// enabling logout
				// .and().logout()

				// customize logount
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
				.logoutSuccessUrl("/user/show_login?logout") //after logout url

				// exception / error handling
				.and().exceptionHandling().accessDeniedPage("/access_denied")

				// add sessionMaxConcurrency count
				.and().sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(true);
		
		http.csrf().disable();

	}
}
