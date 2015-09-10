/**
 * 
 */
package cl.ml.ceppi.core.facade;

import java.util.List;

import cl.ml.ceppi.core.model.equipo.Jugador;

/**
 * @author Maldonado León
 * 
 */
public interface JugadorFacade 
{
	void save(Jugador jugador);

	void update(Jugador jugador);

	void delete(Jugador jugador);

	List<Jugador> listJugadores();

	Jugador findJugadorById(int id);

	List<Jugador> listJugadoresHastaAnio(String anio);
}
