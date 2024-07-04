package com.services.admin_nation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.ui.DefaultLoginPageGeneratingFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailManager() {
		return new InMemoryUserDetailsManager(
			User.withUsername("Lucien").password(passwordEncoder.encode("l30002")).roles("USER").build(),
			User.withUsername("Catalina").password(passwordEncoder.encode("c30003")).roles("USER").build(),
			User.withUsername("Mballa Paul").password(passwordEncoder.encode("m30001")).roles("USER").build(),
			User.withUsername("Pascal").password(passwordEncoder.encode("p0116")).roles("ADMIN").build()
		);
	}
	
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    	http
    	.authorizeRequests()
        .requestMatchers("/static/**", "/dist/**","/plugins/**", "/bibliotheque/**").permitAll()
        .anyRequest().authenticated()
    .and()
    .formLogin()
        .defaultSuccessUrl("/page_region")
        //.failureUrl("/login")
        .permitAll();
		return http.build();
    }
    
    
    
}
