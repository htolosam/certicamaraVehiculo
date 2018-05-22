package com.tolosa.certicamara.vehiculo.apirest.utilidades;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;

public class Respuesta {
	private String mensaje;
	private boolean success;
	private int fila;
	private int columna;
	
	@Value("${mensaje.error.sin.mensaje}")
	private static String MENSAJEERROR; 
	
	private JSONObject respuesta;

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
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

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public JSONObject getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(JSONObject respuesta) throws JSONException {
		if(this.getFila()>=1) 
			respuesta.put("fila", this.getFila());
		if(this.getColumna()>=1) 
			respuesta.put("columna", this.getColumna());
		
		respuesta.put("success", this.isSuccess());
		
		respuesta.put("mensaje", !this.getMensaje().equals("") || this.getMensaje() != null ? this.getMensaje() : MENSAJEERROR);
		
		
		this.respuesta = respuesta;
	} 
}
