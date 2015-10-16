/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.TipoDao;
import cl.ml.ceppi.core.model.tipo.CategoriaSocio;
import cl.ml.ceppi.core.model.tipo.CentroCosto;
import cl.ml.ceppi.core.model.tipo.Profesion;
import cl.ml.ceppi.core.model.tipo.TipoGasto;
import cl.ml.ceppi.core.model.tipo.TipoIngreso;
import cl.ml.ceppi.core.model.tipo.TipoProfesor;
import cl.ml.ceppi.core.model.tipo.TipoSocio;
import cl.ml.ceppi.core.service.TipoService;

/**
 * @author Maldonado León
 *
 */
@Service("tipoService")
public class TipoServiceImpl implements TipoService 
{
	@Autowired
	private TipoDao tipoDao;
	

	@Transactional
	public void save(CategoriaSocio categoriaSocio) {
		tipoDao.save(categoriaSocio);
	}

	@Transactional
	public void save(CentroCosto centroCosto) {
		tipoDao.save(centroCosto);
	}

	@Transactional
	public void save(Profesion profesion) {
		tipoDao.save(profesion);
	}

	@Transactional
	public void save(TipoGasto tipoGasto) {
		tipoDao.save(tipoGasto);
	}

	@Transactional
	public void save(TipoSocio tipoSocio) {
		tipoDao.save(tipoSocio);
	}

	@Transactional
	public void update(CategoriaSocio categoriaSocio) {
		tipoDao.update(categoriaSocio);
	}

	@Transactional
	public void update(CentroCosto centroCosto) {
		tipoDao.update(centroCosto);
	}

	@Transactional
	public void update(Profesion profesion) {
		tipoDao.update(profesion);
	}

	@Transactional
	public void update(TipoGasto tipoGasto) {
		tipoDao.update(tipoGasto);
	}

	@Transactional
	public void update(TipoSocio tipoSocio) {
		tipoDao.update(tipoSocio);
	}

	@Transactional
	public void delete(CategoriaSocio categoriaSocio) {
		tipoDao.delete(categoriaSocio);
	}

	@Transactional
	public void delete(CentroCosto centroCosto) {
		tipoDao.delete(centroCosto);
	}

	@Transactional
	public void delete(Profesion profesion) {
		tipoDao.delete(profesion);
	}

	@Transactional
	public void delete(TipoGasto tipoGasto) {
		tipoDao.delete(tipoGasto);
	}

	@Transactional
	public void delete(TipoSocio tipoSocio) {
		tipoDao.delete(tipoSocio);
	}

	@Transactional
	public List<CategoriaSocio> listCategoriaSocio() {
		return tipoDao.listCategoriaSocio();
	}

	@Transactional
	public List<CentroCosto> listCentroCosto() {
		return tipoDao.listCentroCosto();
	}

	@Transactional
	public List<Profesion> listProfesion() {
		return tipoDao.listProfesion();
	}

	@Transactional
	public List<TipoGasto> listTipoGasto() {
		return tipoDao.listTipoGasto();
	}

	@Transactional
	public List<TipoSocio> listTipoSocio() {
		return tipoDao.listTipoSocio();
	}

	@Transactional
	public CategoriaSocio findCategoriaSocioById(int id) {
		return tipoDao.findCategoriaSocioById(id);
	}

	@Transactional
	public CentroCosto findCentroCostoById(int id) {
		return tipoDao.findCentroCostoById(id);
	}

	@Transactional
	public Profesion findProfesionById(int id) {
		return tipoDao.findProfesionById(id);
	}

	@Transactional
	public TipoGasto findTipoGastoById(int id) {
		return tipoDao.findTipoGastoById(id);
	}

	@Transactional
	public TipoSocio findTipoSocioById(int id) {
		return tipoDao.findTipoSocioById(id);
	}
	
	@Transactional
	public void save(TipoIngreso tipoIngreso) {
		tipoDao.save(tipoIngreso);		
	}

	@Transactional
	public void update(TipoIngreso tipoIngreso) {
		tipoDao.update(tipoIngreso);		
	}

	@Transactional
	public void delete(TipoIngreso tipoIngreso) {
		tipoDao.delete(tipoIngreso);
	}

	@Transactional
	public List<TipoIngreso> listTipoIngreso() {
		return tipoDao.listTipoIngreso();
	}

	@Transactional
	public TipoIngreso findTipoIngresoById(int id) {
		return tipoDao.findTipoIngresoById(id);
	}

	@Override
	public List<TipoProfesor> listTipoProfesor() {
		return tipoDao.listTipoProfesor();
	}

	@Override
	public void save(TipoProfesor obj) {
		tipoDao.save(obj);		
	}

	@Override
	public void update(TipoProfesor obj) {
		tipoDao.update(obj);		
	}

	@Override
	public void delete(TipoProfesor obj) {
		tipoDao.delete(obj);		
	}

}
