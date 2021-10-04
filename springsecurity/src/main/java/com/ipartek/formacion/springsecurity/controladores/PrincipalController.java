package com.ipartek.formacion.springsecurity.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
	@GetMapping("/")
	public String principal() {
		return "index";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin/index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
