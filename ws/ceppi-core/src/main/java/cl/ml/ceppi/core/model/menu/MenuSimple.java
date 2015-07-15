/**
 * 
 */
package cl.ml.ceppi.core.model.menu;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Maldonado León
 *
 */
@Entity
@DiscriminatorValue("SMP")
public class MenuSimple extends Menu implements Serializable{

	private static final long serialVersionUID = 8875880157631646053L;

	/**
	 * 
	 */
	public MenuSimple() {
		// TODO Auto-generated constructor stub
	}

}
