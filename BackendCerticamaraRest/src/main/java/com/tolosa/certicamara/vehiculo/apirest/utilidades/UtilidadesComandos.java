package com.tolosa.certicamara.vehiculo.apirest.utilidades;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Comando;


/**
 * Calse de utilidades de coamndos
 * @author hochi
 *
 */
public class UtilidadesComandos {
	
//	@Autowired
//	private Environment environment;
	
	private static String SEPARADOR_COMANDOS = ";";
	private static String FORMATO = "^[0-9]+,[NSEO]$";

	/**
	 * Metodo para obtener la lista de comandos desglosada y validada
	 * @param comandos String de comandos separados por ;
	 * @return un List de strings on cada comando
	 */
	public static List<String> getListaComandos(String comandos){
		List<String> listaComandos = null;
		listaComandos =  Arrays.asList(comandos.split(SEPARADOR_COMANDOS));
		for(String dato : listaComandos){
		    //imprimimos el objeto pivote
		    System.out.println(dato);
		    if(!UtilidadesComandos.getValidarFormato(dato)) {
		    	listaComandos = null;
		    	break;
		    }
		}
		return listaComandos;
	}
	
	/**
	 * Metodo para validar el comando por medio de una expresion regular
	 * @param comando
	 * @return
	 */
	public static boolean getValidarFormato(String comando) {
		
		return Pattern.matches(FORMATO, comando);		
	}
	
	
	public static Comando getComando(String comando, int fila, int columna, boolean avance) {
		Comando com = new Comando();
		com.setAvance(avance);
		com.setColumna(columna);
		com.setFila(fila);
		com.setComando(comando);
		return com;
	}
}
