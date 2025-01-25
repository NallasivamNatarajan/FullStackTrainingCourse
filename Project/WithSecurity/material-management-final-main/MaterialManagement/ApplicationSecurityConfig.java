package com.htc.org.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableAspectJAutoProxy   //enable aop proxy
//@EnableWebSecurity
public class ApplicationSecurityConfig {
//extends WebSecurityConfigurerAdapter{
	String role ="MANAGER";
	
	//@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {   //user repository.
		//in memory authentication.
		auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("manager").password("welcome").roles(role);
	}

//	@Override
	protected void configure(HttpSecurity http) throws Exception {   //authorization logic
		//http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/authors/","/books","/role/","/user/").hasAnyRole("USER", role)
			.antMatchers("/authors/**").permitAll()
			.antMatchers("/publishers").hasAnyRole(role, "ADMIN")
			.anyRequest().fullyAuthenticated()
			.and().httpBasic();
	}

//	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
}