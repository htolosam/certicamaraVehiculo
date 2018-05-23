package com.tolosa.certicamara.vehiculo.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Superficie;
import com.tolosa.certicamara.vehiculo.apirest.models.services.ISuperficieService;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;

/**
 * Clase encargada de exponer los sevicios web para consumo de
 * la superficie por parte de un cliente
 * @author ho chi 
 */
@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/api")
public class SuperficieRestController {
	
	@Autowired
	private ISuperficieService superficieService;
	
	@GetMapping("/superficie")
	public Optional<List<Superficie>> index(){
		return superficieService.findAll();
	}
	
	@GetMapping("/superficie/{id}")
	public Respuesta show(@PathVariable String id) {
		return superficieService.show(id);
	}
	
	@PostMapping("/superficie")
	@ResponseStatus(HttpStatus.CREATED)
	public Respuesta create(@RequestBody Superficie superficie) {
		return superficieService.save(superficie);
	}
	
	@DeleteMapping("/superficie")
	public void delete() {
		superficieService.delete();
	}
}
