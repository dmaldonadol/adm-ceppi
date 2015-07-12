/**
 * 
 */
package cl.ml.ceppi.core.model.menu;

/**
 * @author Maldonado León
 *
 */
public enum Permiso {
	
	ESCRITURA
	{
		@Override
		public String getCodigo()
		{
			return "E";
		}
	}
	, LECTURA
	{
		@Override
		public String getCodigo() {
			return "L";
		}
	}
	, SIN_ACCESO
	{
		@Override
		public String getCodigo() {
			return "S";
		}
	};
	
	public abstract String getCodigo();
}
