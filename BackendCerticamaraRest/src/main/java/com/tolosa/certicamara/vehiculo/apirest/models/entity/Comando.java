package com.tolosa.certicamara.vehiculo.apirest.models.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase entidad de la coleccion comandos
 * @author ho chi
 *
 */
@Document(collection="comandos")
public class Comando implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	private int fila;
	private int columna;
	private String comando;
	private boolean avance = false;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public String getComando() {
		return comando;
	}
	public void setComando(String comando) {
		this.comando = comando;
	}
	public boolean isAvance() {
		return avance;
	}
	public void setAvance(boolean avance) {
		this.avance = avance;
	}
}
