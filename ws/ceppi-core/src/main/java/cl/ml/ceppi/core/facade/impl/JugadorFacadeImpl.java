package cl.ml.ceppi.core.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.facade.JugadorFacade;
import cl.ml.ceppi.core.model.equipo.Jugador;
import cl.ml.ceppi.core.service.JugadorService;

/**
 * @author Maldonado León
 * 
 */
@Service("jugadorFacade")
public class JugadorFacadeImpl implements JugadorFacade {
	@Autowired
	private JugadorService service;

	@Transactional
	public void save(Jugador obj) {
		service.save(obj);
	}

	@Transactional
	public void update(Jugador obj) {
		service.update(obj);
	}

	@Transactional
	public void delete(Jugador obj) {
		service.delete(obj);
	}

	@Transactional
	public List<Jugador> listJugadores() {
		return service.listJugadores();
	}

	@Transactional
	public Jugador findJugadorById(int id) {
		return service.findJugadorById(id);
	}
	
	@Transactional
	public List<Jugador> listJugadoresHastaAnio(String anio)
	{
		return service.listJugadoresHastaAnio(anio);
	}
}
