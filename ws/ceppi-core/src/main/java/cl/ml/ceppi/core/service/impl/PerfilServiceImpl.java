/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.PerfilDao;
import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.core.service.PerfilService;

/**
 * @author Maldonado León
 * 
 */
@Service("perfilService")
public class PerfilServiceImpl implements PerfilService {
	@Autowired
	private PerfilDao perfilDao;

	@Transactional
	public void save(Perfil perfil) {
		perfilDao.save(perfil);
	}

	@Transactional
	public void saveMenu(Menu menu) {
		perfilDao.saveMenu(menu);
	}

	@Transactional
	public void update(Perfil perfil) {
		perfilDao.update(perfil);
	}

	@Transactional
	public void update(Menu menu) {
		perfilDao.update(menu);
	}

	@Transactional
	public void delete(Perfil perfil) {
		perfilDao.delete(perfil);
	}

	@Transactional
	public void delete(Menu menu) {
		perfilDao.delete(menu);
	}

	@Transactional
	public List<Perfil> listPerfil() {
		return perfilDao.listPerfil();
	}

	@Transactional
	public List<Menu> listMenu() {
		return perfilDao.listMenu();
	}

	@Transactional
	public Perfil findPerfilById(int id) {
		return perfilDao.findPerfilById(id);
	}

	@Transactional
	public Menu findMenuById(int id) {
		return perfilDao.findMenuById(id);
	}
	
	public List<Acceso> listaAccesoByIdPerfil(int id)
	{
		return perfilDao.listaAccesoByIdPerfil(id);
	}

}
