package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.acceso.Acceso;
import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.menu.MenuCompuesto;
import cl.ml.ceppi.core.model.perfil.Perfil;

/**
 * @author Maldonado León
 *
 */
public interface PerfilFacade 
{
	void save(Perfil perfil);
	void saveMenu(Menu menu);
	void saveAcceso(Acceso acceso);
	
	void update(Perfil perfil);
	void update(Menu menu);
	
	void delete(Perfil perfil);
	void delete(Menu menu);
	
	List<Perfil> listPerfil();
	List<MenuCompuesto> listMenu();
		
	Perfil findPerfilById(int id);
	Menu findMenuById(int id);
	Acceso findAccesoById(int id);
	
	List<Acceso> listaAccesoByIdPerfil(int id);
	Menu findMenuByCodigo(String codigo);
	void delete(Acceso acceso);
	
}
