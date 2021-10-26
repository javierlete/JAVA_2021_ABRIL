package com.ipartek.formacion.factorydalspring.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.factorydalspring.repositorios.destino.PersonaDestinoRepository;
import com.ipartek.formacion.factorydalspring.repositorios.origen.PersonaOrigenRepository;

@Controller
@RequestMapping("/personas")
public class PersonasController {
	
	@Autowired
	private PersonaOrigenRepository daoOrigen;
	
	@Autowired
	private PersonaDestinoRepository daoDestino;
	
	@GetMapping("/origen")
	@Transactional("origenTransactionManager")
	public String getOrigen(Model modelo) {
		modelo.addAttribute("personas", daoOrigen.findAll());
		return "personas";
	}
	
	@GetMapping("/destino")
	@Transactional("origenTransactionManager")
	public String getDestino(Model modelo) {
		modelo.addAttribute("personas", daoDestino.findAll());
		return "personas";
	}
}
