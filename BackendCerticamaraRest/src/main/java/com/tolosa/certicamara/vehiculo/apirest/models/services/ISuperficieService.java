package com.tolosa.certicamara.vehiculo.apirest.models.services;

import java.util.List;
import java.util.Optional;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Superficie;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;


public interface ISuperficieService {
	public Optional<List<Superficie>> findAll();
	/**
	 * Metodo para guardar los datos de una superficie
	 * @param superficie
	 * @return
	 */
	public Respuesta save(Superficie superficie);
	
	/**
	 * Metodo para mostrar los datos de una superficie
	 * @param id
	 * @return
	 */
	public Respuesta show(String id);
	
	/**
	 * Metodo para eliminar todos los datos de la coleccion superficies en la bd
	 */
	public void delete();
	
}
