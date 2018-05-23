package com.tolosa.certicamara.vehiculo.apirest.models.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Comando;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.UtilidadesComandos;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.UtilidadesDesplazamiento;

/**
 * clase encar
 * @author ho chi
 *
 */
@Repository
public class ComandoDaoIml implements IComandoDao {

private MongoOperations mope;
	
	

	@Autowired
	private Environment environment;
	
	@Autowired
	private ISuperficieDao superficieDao;
	
    public ComandoDaoIml(ISuperficieDao superficieDao){
    	
        this.superficieDao = superficieDao;
    }
	
	@SuppressWarnings("deprecation")
	@Autowired
	public ComandoDaoIml(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mope = mongoOperations;
	}
	
	@Override
	public Respuesta save(Comando comando) {
		boolean estado = false;
		Respuesta res = new Respuesta();
		List<String> comandos = null;
		//debemos validar comando para obtener el o los comandos desmenuzados
		try {
			if(comando.getComando().equals("") || comando.getComando() == null) {
				res.setSuccess(estado);
				res.setMensaje(environment.getProperty("mensaje.error.validar.formato.comando.vacio"));
				return res;
			}
			comandos = UtilidadesComandos.getListaComandos(comando.getComando());
			if(comandos == null) {
				res.setSuccess(estado);
				res.setMensaje(environment.getProperty("mensaje.error.validar.formato.comando"));
			}
			//obtenemos el ultimo comando que se guardo con exito y que sera nuestro punto de partida
			Comando ultimoComando = this.getUltimoComando();
			if(ultimoComando.isAvance()) {
				res.setSuccess(estado);
				res.setMensaje(environment.getProperty("mensaje.error.validar.avance.superficie"));
			}
			//obtenemos la lista de comandos cion sus respectivas posiciones para guardar en la bd
			List<Comando> listaComandos = UtilidadesDesplazamiento.getDesplazamientoComando(comandos, superficieDao.show("1"), this.getUltimoComando());
			for (Comando cmd : listaComandos) {

				this.mope.save(cmd);
				res = this.show(cmd.getId());
				estado = true;
				res.setSuccess(estado);
				//si la variable avance es verdadera se actualiza en el comando actual para que no se pueda
				//seguir con el ingreso de mas comandos para desplazarse
				if(cmd.isAvance()) {
					res.setSuccess(estado);
					res.setMensaje(environment.getProperty("mensaje.error.validar.avance.superficie"));
					break;
				}
			}
		}catch (Exception  e) {
			res.setSuccess(false);
			res.setMensaje(environment.getProperty("mensaje.error.validar.formato.comando.vacio"));
		}
		
		return res;
	}

	
	@Override
	public Respuesta show(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(id));
		Comando cmd = this.mope.findOne(query, Comando.class);
		Respuesta res = new Respuesta();
		res.setFila(cmd.getFila());
		res.setColumna(cmd.getColumna());
		res.setSuccess(true);
		res.setMensaje(environment.getProperty("mensaje.success"));
		return res;
	}
	
	@Override
	public Respuesta delete() {
		Respuesta res = new Respuesta();
		this.mope.remove(new Query(), Comando.class);
		Comando cmd = this.crearPrimerComando();
		res.setFila(cmd.getFila());
		res.setColumna(cmd.getColumna());
		res.setSuccess(true);
		res.setMensaje(environment.getProperty("mensaje.success"));
		return res;
	}
	
	@Override
	public Respuesta getPosicionVehiculo() {
		Respuesta res = new Respuesta();
		Comando cmd = this.getUltimoComando();
		res.setFila(cmd.getFila());
		res.setColumna(cmd.getColumna());
		res.setSuccess(true);
		res.setMensaje(environment.getProperty("mensaje.success"));
		return res;
	}
	
	/**
	 * Metodo para obtener el ultimo comando que se guardo con exito
	 * @return
	 */
	private Comando getUltimoComando() {
		Query query = new Query();
	    query.limit(1);
	    query.with(new Sort(Sort.Direction.DESC, "_id"));
		Comando cmd = this.mope.findOne(query, Comando.class);
		if(cmd == null) {
			cmd = this.crearPrimerComando();
		}
		return cmd;
	}
	
	/**
	 * Metodo para crear comando por defecto
	 * @return
	 */
	private Comando crearPrimerComando() {
		Comando cmd = UtilidadesComandos.getComando("-", 0, 0, false);
		this.mope.save(cmd);
		return cmd;
	}

}
