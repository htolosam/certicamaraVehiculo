package com.tolosa.certicamara.vehiculo.apirest.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Comando;
/**
 * Clase utilidad para procesar la informacion de los desplazamientos del vehiculo
 * @author hochi
 *
 */
public class UtilidadesDesplazamiento {

	private static String SEPARADOR_COMANDO = ",";
	private static final String NORTE = "N";
	private static final String SUR = "S";
	private static final String ESTE = "E";
	private static final String OESTE = "O";
	private static final int POSICION_FILA_MINIMA = 0;
	private static final int POSICION_COLUMNA_MINIMA = 0;

	/**
	 * Metodo para obtener el desplazamiento por cada comando, si el avance no se puede porque
	 * se desborda de la superficie cancelamos la operacion y guardamos la variable avance en true
	 * para no dejar seguir ningun proceso hasta que se reinicie
	 * @param comandos Lista de comandos
	 * @param respSuperficie Superficie donde el vehiculo se puede desplazar
	 * @param comm Ultimo comando con los datos para el inicio del desplazamiento
	 * @return Retorna una lista de comandos con sus respectivas posiciones en la superficie
	 */
	public static List<Comando> getDesplazamientoComando(List<String> comandos, Respuesta respSuperficie, Comando comm) {
		
		String desplazamiento = null;
		String direccion = null;
		boolean detenerAvance = false;

		int filaSuperficie = respSuperficie.getFila();;
		int columnaSuperficie = respSuperficie.getColumna();

		int pFilaActual = comm.getFila();
		int pColumnaActual = comm.getColumna();

		List<Comando> respComandos = new ArrayList<Comando>();

		for (String comando : comandos) {
			String[] partesComando = comando.split(SEPARADOR_COMANDO);
			desplazamiento = partesComando[0];
			direccion = partesComando[1];
			switch (direccion) {
			case NORTE:
				pFilaActual += Integer.parseInt(desplazamiento);
				if (pFilaActual > filaSuperficie)
					detenerAvance = true;
				break;
			case ESTE:
				pColumnaActual += Integer.parseInt(desplazamiento);
				if (pColumnaActual > columnaSuperficie) {
					detenerAvance = true;
				}

				break;
			case SUR:
				pFilaActual -= Integer.parseInt(desplazamiento);
				if (pFilaActual < POSICION_FILA_MINIMA) {
					detenerAvance = true;
				}

				break;
			case OESTE:
				pColumnaActual -= Integer.parseInt(desplazamiento);
				if (pColumnaActual < POSICION_COLUMNA_MINIMA) {
					detenerAvance = true;
				} 

				break;
			}
			
			if(detenerAvance) {
				respComandos = new ArrayList<Comando>();
				comm.setAvance(detenerAvance);
				respComandos.add(comm);
				break;
			}else {
				respComandos.add(UtilidadesComandos.getComando(comando, pFilaActual, pColumnaActual, detenerAvance));
				
			}
		}

		return respComandos;
	}

}
