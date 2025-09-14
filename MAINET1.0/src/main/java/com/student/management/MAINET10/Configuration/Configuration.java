package com.student.management.MAINET10.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security)throws Exception {
		return security
				.authorizeHttpRequests(auth -> auth
				.requestMatchers("/Home.html").permitAll()
				.requestMatchers("/contacts").permitAll()
				.anyRequest().authenticated())
				.formLogin(form -> form
						.defaultSuccessUrl("/", true))
				.logout(Config -> Config.logoutSuccessUrl("/"))
				.build(); 
		}
	
	}