package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.PerfilFacade;
import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.perfil.Perfil;
import cl.ml.ceppi.core.service.PerfilService;

/**
 * @author Maldonado León
 *
 */
@Service("perfilFacade")
public class PerfilFacadeImpl implements PerfilFacade 
{
	@Autowired
	private PerfilService perfilService;

	@Transactional
	public void save(Perfil perfil) {
		perfilService.save(perfil);
	}

	@Transactional
	public void saveMenu(Menu menu) {
		perfilService.saveMenu(menu);
	}

	@Transactional
	public void update(Perfil perfil) {
		perfilService.update(perfil);
	}

	@Transactional
	public void update(Menu menu) {
		perfilService.update(menu);
	}

	@Transactional
	public void delete(Perfil perfil) {
		perfilService.delete(perfil);
	}

	@Transactional
	public void delete(Menu menu) {
		perfilService.delete(menu);
	}

	@Transactional
	public List<Perfil> listPerfil() {
		return perfilService.listPerfil();
	}

	@Transactional
	public List<MenuCompuesto> listMenu() {
		return perfilService.listMenu();
	}

	@Transactional
	public Perfil findPerfilById(int id) {
		return perfilService.findPerfilById(id);
	}

	@Transactional
	public Menu findMenuById(int id) {
		return perfilService.findMenuById(id);
	}
	
	@Transactional
	public List<Acceso> listaAccesoByIdPerfil(int id)
	{
		return perfilService.listaAccesoByIdPerfil(id);
	}

	@Transactional
	public void saveAcceso(Acceso acceso) {
		// TODO Auto-generated method stub
		perfilService.saveAcceso(acceso);
	}

	@Transactional
	public Acceso findAccesoById(int id) {
		// TODO Auto-generated method stub
		return perfilService.findAccesoById(id);
	}

	@Transactional
	public Menu findMenuByCodigo(String codigo) {
		// TODO Auto-generated method stub
		return perfilService.findMenuByCodigo(codigo);
	}

	@Transactional
	public void delete(Acceso acceso) {
		perfilService.delete(acceso);
	}

	
}
