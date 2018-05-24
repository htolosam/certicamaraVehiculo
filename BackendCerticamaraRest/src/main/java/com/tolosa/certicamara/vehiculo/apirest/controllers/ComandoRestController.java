package com.tolosa.certicamara.vehiculo.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Comando;
import com.tolosa.certicamara.vehiculo.apirest.models.services.IComandoService;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;

/**
 * Clase encargada de exponer los sevicios web para consumo de los comandos
 * por parte de un cliente
 * @author ho chi *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/com")
public class ComandoRestController {
	@Autowired
	private IComandoService comandoService;
	
	@GetMapping("/comando/listar")
	public Respuesta index() {
		return comandoService.listar();
	}
	
	@PostMapping("/comando")
	@ResponseStatus(HttpStatus.CREATED)
	public Respuesta create(@RequestBody Comando comando) {
		return this.comandoService.save(comando);
	}
	
	@DeleteMapping("/comando")
	public Respuesta delete() {
		return comandoService.delete();
	}
	
	@GetMapping("/comando")
	public Respuesta show() {
		return comandoService.getPosicionVehiculo();
	}

}
