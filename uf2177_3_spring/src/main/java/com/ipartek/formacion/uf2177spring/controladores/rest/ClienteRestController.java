package com.ipartek.formacion.uf2177spring.controladores.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.uf2177spring.accesodatos.Dao;
import com.ipartek.formacion.uf2177spring.modelos.Cliente;

@RestController
@RequestMapping("/api/clientes")
public class ClienteRestController {
	@Autowired
	private Dao<Cliente> dao;
	
	@GetMapping
	public Iterable<Cliente> get() {
		return dao.obtenerTodos();
	}

	@GetMapping("{id}")
	public ResponseEntity<Cliente> getConId(@PathVariable Long id) {
		Cliente cliente = dao.obtenerPorId(id);
		
		if(cliente != null) {
			return new ResponseEntity<>(cliente, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente post(@RequestBody Cliente cliente) {
		return dao.insertar(cliente);
	}
	
	@PutMapping
	public Cliente put(@RequestBody Cliente cliente) {
		return dao.modificar(cliente);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		dao.borrar(id);
	}
}
