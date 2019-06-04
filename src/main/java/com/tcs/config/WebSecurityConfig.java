package com.tcs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tcs.service.UserServiceImpl;

/**
 * @author german_ariza
 * 
 *         Clase utilizada para setear la configuración de Spring Security sobre
 *         las vistas de la aplicación.
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	String[] resources = new String[] { "/css/**", "/img/**", "/js/**" };
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	UserServiceImpl userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	}

	/**
	 * Configuración de acceso sobre las vistas y vistas heredadas.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/", "/index").permitAll()
				.antMatchers("/product*").access("hasRole('ADMIN')").antMatchers("/client*").access("hasRole('USER')")
				.antMatchers("/pago*").access("hasRole('USER')").anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/menu").failureUrl("/login?error=true")
				.usernameParameter("username").passwordParameter("password").and().logout().permitAll()
				.logoutSuccessUrl("/login?logout");
	}

	/**
	 * Método encargado de encriptar passwords, los cuales seran comparados contra
	 * su hash en base de datos.
	 * 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(Constants.STRENGTH_HASH);
		return bCryptPasswordEncoder;
	}

}