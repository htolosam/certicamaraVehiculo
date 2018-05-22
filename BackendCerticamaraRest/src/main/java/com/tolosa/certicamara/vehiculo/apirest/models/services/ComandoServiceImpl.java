package com.tolosa.certicamara.vehiculo.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tolosa.certicamara.vehiculo.apirest.models.dao.IComandoDao;
import com.tolosa.certicamara.vehiculo.apirest.models.entity.Comando;
import com.tolosa.certicamara.vehiculo.apirest.utilidades.Respuesta;

@Service
public class ComandoServiceImpl implements IComandoService {

	@Autowired
	private IComandoDao comandoDao;

	@Autowired
	public ComandoServiceImpl(IComandoDao comandoDao) {
		this.comandoDao = comandoDao;
	}

	@Override
	public Respuesta save(Comando comando) {
		return comandoDao.save(comando);
	}

	@Override
	public Respuesta show(String id) {
		return comandoDao.show(id);
	}

	@Override
	public Respuesta delete() {
		// TODO Auto-generated method stub
		return comandoDao.delete();
	}

	@Override
	public Respuesta getPosicionVehiculo() {
		// TODO Auto-generated method stub
		return comandoDao.getPosicionVehiculo();
	}



}
