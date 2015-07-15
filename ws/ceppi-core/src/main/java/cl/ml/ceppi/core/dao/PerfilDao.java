/**
 * 
 */
package cl.ml.ceppi.core.dao;

import java.util.List;

import cl.ml.ceppi.core.model.menu.Menu;
import cl.ml.ceppi.core.model.perfil.Perfil;

/**
 * @author Maldonado León
 *
 */
public interface PerfilDao 
{
	void save(Perfil perfil);
	void saveMenu(Menu menu);
	
	void update(Perfil perfil);
	void update(Menu menu);
	
	void delete(Perfil perfil);
	void delete(Menu menu);
	
	List<Perfil> listPerfil();
	List<Menu> listMenu();
		
	Perfil findPerfilById(int id);
	Menu findMenuById(int id);
}
