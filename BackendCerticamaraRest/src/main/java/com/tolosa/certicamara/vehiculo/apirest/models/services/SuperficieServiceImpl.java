package com.tolosa.certicamara.vehiculo.apirest.models.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.tolosa.certicamara.vehiculo.apirest.models.dao.ISuperficieDao;
import com.tolosa.certicamara.vehiculo.apirest.models.entity.Superficie;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;

@Service
public class SuperficieServiceImpl implements ISuperficieService {

	@Autowired
	private ISuperficieDao superficieDao;
	private MongoOperations mope;

	@Autowired
	public SuperficieServiceImpl(ISuperficieDao superficieDao) {
		this.superficieDao = superficieDao;
	}

	@Override
	public Optional<List<Superficie>> findAll() {
		List<Superficie> s = this.mope.find(new Query(), Superficie.class);
		Optional<List<Superficie>> superficie = Optional.ofNullable(s);
		return superficie;
	}

	@Override
	public Respuesta save(Superficie superficie) {
		return superficieDao.save(superficie);
	}

	@Override
	public Respuesta show(String id) {
		return superficieDao.show(id);

	}

	@Override
	public void delete() {
		this.superficieDao.delete();
	}

}
