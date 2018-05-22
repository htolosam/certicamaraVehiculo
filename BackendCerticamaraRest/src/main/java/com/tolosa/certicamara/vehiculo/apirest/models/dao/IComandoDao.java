package com.tolosa.certicamara.vehiculo.apirest.models.dao;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Comando;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;

public interface IComandoDao {
	
//	/**
//	 * Metodo para crear comando por defecto
//	 * @return
//	 */
//	public Comando crearPrimerComando();
	
	/**
	 * Metodo para guardar uno o varios comandos
	 * @param comando Objeto comando con los datos a guardar
	 * @return devuelve un objeto respuesta con la información del ultimo comando guardado
	 */
	public Respuesta save(Comando comando);
	
	/**
	 * Metodo para mostrar la informacion de un comando
	 * @param id parametro identificador del comando
	 * @return Retorna un objeto respuesta con la informacion del comando
	 */
	public Respuesta show(String id);
	
	/**
	 * Metodo para eliminar todos los comandos
	 */
	public Respuesta delete();
	
	
	/**
	 * Metodo para obtener el ultimo Comando ejecutado por el usuario
	 * @return
	 */
	public Respuesta getPosicionVehiculo();
	
	
}
