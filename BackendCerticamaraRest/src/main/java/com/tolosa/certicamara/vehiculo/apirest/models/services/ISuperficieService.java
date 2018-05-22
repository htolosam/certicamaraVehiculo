package com.tolosa.certicamara.vehiculo.apirest.models.services;

import java.util.List;
import java.util.Optional;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Superficie;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;


public interface ISuperficieService {
	public Optional<List<Superficie>> findAll();
	public Respuesta save(Superficie superficie);
//	public Superficie show(String id);
	public Respuesta show(String id);
	
	
	public void delete();
	
}
