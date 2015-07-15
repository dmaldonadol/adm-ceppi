/**
 * 
 */
package cl.ml.ceppi.core.model.menu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * @author Maldonado León
 * 
 */
@Entity
@DiscriminatorValue("CMP")
public class MenuCompuesto extends Menu implements Serializable {

	private static final long serialVersionUID = -115448101300556149L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "menu")
	@Cascade({ CascadeType.ALL })
	private List<Menu> itemMenu = new ArrayList<Menu>();

	/**
	 * 
	 */
	public MenuCompuesto() {
		// TODO Auto-generated constructor stub
	}

	public List<Menu> getItemMenu() {
		return itemMenu;
	}

	public void setItemMenu(List<Menu> itemMenu) {
		this.itemMenu = itemMenu;
	}

}
