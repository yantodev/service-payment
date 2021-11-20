package com.yantodev.transaksi;
import	com.yantodev.transaksi.config.JWTAutorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class TransaksiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransaksiApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
					.addFilterAfter(new JWTAutorization(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/user/login").permitAll()
					.antMatchers(HttpMethod.GET, "/user").permitAll()
					.antMatchers(HttpMethod.GET, "/product").permitAll()
					.antMatchers(HttpMethod.POST, "/user/add-user").permitAll()
					.anyRequest().authenticated();
		}
	}

}
