/**
 * 
 */
package cl.ml.ceppi.core.model.menu;

/**
 * @author Maldonado León
 *
 */
public enum Permiso {
	
	E
	{
		@Override
		public String getNombre()
		{
			return "ESCRITURA";
		}
	}
	, L
	{
		@Override
		public String getNombre() {
			return "LECTURA";
		}
	}
	, S
	{
		@Override
		public String getNombre() {
			return "SIN_ACCESO";
		}
	};
	
	public abstract String getNombre();
}
