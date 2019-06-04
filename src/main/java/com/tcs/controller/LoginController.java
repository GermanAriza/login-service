package com.tcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author german_ariza
 * 
 *         Clase encargada de exponer el controlador y cada uno de los servicios
 *         del login de la aplicación
 *
 */
@Controller
public class LoginController {

	@GetMapping({ "/", "/login" })
	public String index() {
		return "index";
	}

	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}

	@GetMapping("/product")
	public String product() {
		return "product";
	}

	@GetMapping("/client")
	public String client() {
		return "client";
	}

	@GetMapping("/pago")
	public String pago() {
		return "pago";
	}
}
