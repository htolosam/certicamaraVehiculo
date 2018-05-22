package com.tolosa.certicamara.vehiculo.apirest.models.dao;

import java.util.List;
import java.util.Optional;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Superficie;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;


public interface ISuperficieDao {
	public Optional<List<Superficie>> findAll();
	public Respuesta save(Superficie superficie);
	public Respuesta show(String id);
	public void delete();
}
