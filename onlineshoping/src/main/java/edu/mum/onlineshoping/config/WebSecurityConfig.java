package edu.mum.onlineshoping.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomSuccessHandler customSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/**").access("hasRole('USER')").antMatchers("/admin/**")
				.access("hasRole('ADMIN')").antMatchers("/", "/home", "/register").permitAll().anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
//				.failureUrl("/login?error")
				.permitAll()
				.successHandler(customSuccessHandler)
				.and()
				.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login").permitAll();
//		http.rememberMe().rememberMeParameter("rememberMe");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("user@gmail.com").password("123").roles("USER");
	}
}