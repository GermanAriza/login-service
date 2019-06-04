package com.tcs.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tcs.config.Constants;

/**
 * @author german_ariza
 * 
 *         Clase encargada de generar clave encriptada para utilizar en la
 *         autenticación de Spring Security.
 *
 */
public class PasswordGenerator {

	public static void main(String... args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(Constants.STRENGTH_HASH);
		System.out.println(bCryptPasswordEncoder.encode(Constants.PASSWORD));
		// $2a$10$Ak82IET4CgS8jxfHz4Rzm.OyQ9lt6NEvfH/RSsR37jqBiLcMrfsZG
	}
}
