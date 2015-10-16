package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.TipoFacade;
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
@Service("tipoFacade")
public class TipoFacadeImpl implements TipoFacade 
{
	@Autowired
	private TipoService tipoService;

	@Transactional
	public void save(CategoriaSocio categoriaSocio) {
		tipoService.save(categoriaSocio);
	}

	@Transactional
	public void save(CentroCosto centroCosto) {
		tipoService.save(centroCosto);
	}

	@Transactional
	public void save(Profesion profesion) {
		tipoService.save(profesion);
	}

	@Transactional
	public void save(TipoGasto tipoGasto) {
		tipoService.save(tipoGasto);
	}

	@Transactional
	public void save(TipoSocio tipoSocio) {
		tipoService.save(tipoSocio);
	}

	@Transactional
	public void update(CategoriaSocio categoriaSocio) {
		tipoService.update(categoriaSocio);
	}

	@Transactional
	public void update(CentroCosto centroCosto) {
		tipoService.update(centroCosto);
	}

	@Transactional
	public void update(Profesion profesion) {
		tipoService.update(profesion);
	}

	@Transactional
	public void update(TipoGasto tipoGasto) {
		tipoService.update(tipoGasto);
	}

	@Transactional
	public void update(TipoSocio tipoSocio) {
		tipoService.update(tipoSocio);
	}

	@Transactional
	public void delete(CategoriaSocio categoriaSocio) {
		tipoService.delete(categoriaSocio);
	}

	@Transactional
	public void delete(CentroCosto centroCosto) {
		tipoService.delete(centroCosto);
	}

	@Transactional
	public void delete(Profesion profesion) {
		tipoService.delete(profesion);
	}

	@Transactional
	public void delete(TipoGasto tipoGasto) {
		tipoService.delete(tipoGasto);
	}

	@Transactional
	public void delete(TipoSocio tipoSocio) {
		tipoService.delete(tipoSocio);
	}

	@Transactional
	public List<CategoriaSocio> listCategoriaSocio() {
		return tipoService.listCategoriaSocio();
	}

	@Transactional
	public List<CentroCosto> listCentroCosto() {
		return tipoService.listCentroCosto();
	}

	@Transactional
	public List<Profesion> listProfesion() {
		return tipoService.listProfesion();
	}

	@Transactional
	public List<TipoGasto> listTipoGasto() {
		return tipoService.listTipoGasto();
	}

	@Transactional
	public List<TipoSocio> listTipoSocio() {
		return tipoService.listTipoSocio();
	}

	@Transactional
	public CategoriaSocio findCategoriaSocioById(int id) {
		return tipoService.findCategoriaSocioById(id);
	}

	@Transactional
	public CentroCosto findCentroCostoById(int id) {
		return tipoService.findCentroCostoById(id);
	}

	@Transactional
	public Profesion findProfesionById(int id) {
		return tipoService.findProfesionById(id);
	}

	@Transactional
	public TipoGasto findTipoGastoById(int id) {
		return tipoService.findTipoGastoById(id);
	}

	@Transactional
	public TipoSocio findTipoSocioById(int id) {
		return tipoService.findTipoSocioById(id);
	}

	@Transactional
	public void save(TipoIngreso tipoIngreso) {
		tipoService.save(tipoIngreso);		
	}

	@Transactional
	public void update(TipoIngreso tipoIngreso) {
		tipoService.update(tipoIngreso);		
	}

	@Transactional
	public void delete(TipoIngreso tipoIngreso) {
		tipoService.delete(tipoIngreso);
	}

	@Transactional
	public List<TipoIngreso> listTipoIngreso() {
		return tipoService.listTipoIngreso();
	}

	@Transactional
	public TipoIngreso findTipoIngresoById(int id) {
		return tipoService.findTipoIngresoById(id);
	}

	@Transactional
	public List<TipoProfesor> listTipoProfesor() {
		return tipoService.listTipoProfesor();
	}

	@Override
	public void save(TipoProfesor obj) {
		tipoService.save(obj);
	}

	@Override
	public void update(TipoProfesor obj) {
		tipoService.update(obj);		
	}

	@Override
	public void delete(TipoProfesor obj) {
		tipoService.delete(obj);
	}

}
