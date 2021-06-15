package com.sample.app.configuration;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
@Configuration
@EnableWebSecurity
public class Spring_security_config extends WebSecurityConfigurerAdapter{

/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManager userdetailservice=new InMemoryUserDetailsManager();
		
		UserDetails user1=User.withUsername("sameeha").password("sam").authorities("admin").build();
		UserDetails user2=User.withUsername("sheik").password("abu").authorities("user").build();
		
		userdetailservice.createUser(user1);
		userdetailservice.createUser(user2);
		auth.userDetailsService(userdetailservice);
		
	
		
	}*/
	
	/*@Bean
	public UserDetailsService UserDetailsService(DataSource datasource) {
		return new JdbcUserDetailsManager(datasource);
	}*/
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				// TODO Auto-generated method stub
				CorsConfiguration config=new CorsConfiguration();
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setMaxAge(3600L);
				return config;
			}
		}).and().csrf().disable()
		.authorizeRequests().antMatchers("/api/checkservice").authenticated()
		.antMatchers("/api/addition").authenticated()
		.antMatchers("/api/subtraction").authenticated()
		.antMatchers("/api/register").permitAll().and().formLogin().and().httpBasic();
	}
	
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	

}
