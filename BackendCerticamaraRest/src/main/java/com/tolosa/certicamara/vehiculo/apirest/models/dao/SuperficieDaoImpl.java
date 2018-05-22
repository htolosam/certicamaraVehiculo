package com.tolosa.certicamara.vehiculo.apirest.models.dao;

import java.util.List;
import org.springframework.data.mongodb.core.MongoOperations;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.tolosa.certicamara.vehiculo.apirest.models.entity.Superficie;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;

@Repository
public class SuperficieDaoImpl implements ISuperficieDao{

	private MongoOperations mope;
	
	@Autowired
	private Environment environment;
	
	@SuppressWarnings("deprecation")
	@Autowired
	public SuperficieDaoImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mope = mongoOperations;
	}
	
	
	@Override
	public Optional<List<Superficie>> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Respuesta save(Superficie superficie) {
		Respuesta res = new Respuesta();
		if(superficie.getFila()>0 && superficie.getColumna()>0) {
			this.delete();
			this.mope.save(superficie);
			res = this.show(superficie.getId());
		}else {
			res.setSuccess(false);
			res.setMensaje(environment.getProperty("mensaje.error.validar.crear.superficie"));
		}
		return res;
	}

	@Override
	public Respuesta show(String id) {
		Superficie sup = this.mope.findOne(new Query(), Superficie.class);
		Respuesta res = new Respuesta();
		res.setFila(sup.getFila());
		res.setColumna(sup.getColumna());
		res.setSuccess(true);
		res.setMensaje(environment.getProperty("mensaje.success"));
		return res;
	}

	@Override
	public void delete() {
		this.mope.remove(new Query(), Superficie.class);
	}

}
