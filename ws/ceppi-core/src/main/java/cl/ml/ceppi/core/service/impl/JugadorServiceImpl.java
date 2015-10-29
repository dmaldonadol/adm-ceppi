/**
 * 
 */
package cl.ml.ceppi.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ml.ceppi.core.dao.JugadorDao;
import cl.ml.ceppi.core.model.equipo.Jugador;
import cl.ml.ceppi.core.service.JugadorService;

/**
 * @author Maldonado León
 * 
 */
@Service("jugadorService")
public class JugadorServiceImpl implements JugadorService 
{
	@Autowired
	private JugadorDao dao;

	@Transactional
	public void save(Jugador obj) {
		dao.save(obj);
	}

	@Transactional
	public void update(Jugador obj) {
		dao.update(obj);
	}

	@Transactional
	public void delete(Jugador obj) {
		dao.delete(obj);
	}

	@Transactional
	public List<Jugador> listJugadores() {
		return dao.listJugadores();
	}

	@Transactional
	public Jugador findJugadorById(int id) {
		return dao.findJugadorById(id);
	}
	
	@Transactional
	public List<Jugador> listJugadoresHastaAnio(String anio)
	{
		return dao.listJugadoresHastaAnio(anio);
	}

	@Override
	public Jugador findJugadorByRut(String rut) 
	{
		return dao.findJugadorByRut(rut);
	}

}
