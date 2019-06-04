package com.tcs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tcs.config.Constants;
import com.tcs.model.Authority;
import com.tcs.repository.UserRepository;

/**
 * @author german_ariza
 * 
 *         Clase encargada de ofrecr los servicios de negocio referentes al
 *         usuario.
 *
 */
@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	/**
	 * Método encargado de obtener el Usuario filtrado por su nombre de usuario.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		com.tcs.model.User appUser = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(Constants.USER_NO_EXIST));

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (Authority authority : appUser.getAuthority()) {
			// ROLE_USER, ROLE_ADMIN,..
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantList.add(grantedAuthority);
		}

		UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
		return user;
	}
}