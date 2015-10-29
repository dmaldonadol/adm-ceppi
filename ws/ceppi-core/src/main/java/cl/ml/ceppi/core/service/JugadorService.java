package cl.ml.ceppi.core.service;

import java.util.List;

import cl.ml.ceppi.core.model.equipo.Jugador;

/**
 * @author Maldonado León
 *
 */
public interface JugadorService 
{
	void save(Jugador obj);

	void update(Jugador obj);

	void delete(Jugador obj);

	List<Jugador> listJugadores();

	Jugador findJugadorById(int id);
	
	List<Jugador> listJugadoresHastaAnio(String anio);

	Jugador findJugadorByRut(String rut);
}
