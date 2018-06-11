package cl.ml.ceppi.core.service;

import java.util.List;

import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.perfil.Perfil;

/**
 * @author Maldonado León
 *
 */
public interface PerfilService 
{
	void save(Perfil perfil);
	void saveMenu(Menu menu);
	
	void update(Perfil perfil);
	void update(Menu menu);
	
	void delete(Perfil perfil);
	void delete(Menu menu);
	
	List<Perfil> listPerfil();
	List<MenuCompuesto> listMenu();
	List<MenuCompuesto> listMenuPerfil( int idPerfil );
		
	Perfil findPerfilById(int id);
	Menu findMenuById(int id);
	
	List<Acceso> listaAccesoByIdPerfil(int id);
	void saveAcceso(Acceso acceso);
	Acceso findAccesoById(int id);
	Menu findMenuByCodigo(String codigo);
	void delete(Acceso acceso);
}
