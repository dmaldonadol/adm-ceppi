package cl.ml.ceppi.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cl.ml.ceppi.core.dao.CuotaDao;
import cl.ml.ceppi.core.model.cuota.Cuota;
import cl.ml.ceppi.core.model.cuota.RegistroCuota;
import cl.ml.ceppi.core.model.cuota.ValorCuota;

/**
 * @author Maldonado León
 * 
 */
@Repository("CuotaDao")
public class CuotaDaoImpl implements CuotaDao {
	@Autowired
	private SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Cuota cuota) {
		getSession().persist(cuota);		
	}

	@Override
	public void save(ValorCuota valorCuota) {
		getSession().persist(valorCuota);
	}

	@Override
	public void save(RegistroCuota registroCuota) {
		getSession().persist(registroCuota);
	}

	@Override
	public void update(Cuota cuota) {
		getSession().update(cuota);
	}

	@Override
	public void update(ValorCuota valorCuota) {
		getSession().update(valorCuota);		
	}

	@Override
	public void update(RegistroCuota registroCuota) {
		getSession().update(registroCuota);		
	}

	@Override
	public void delete(Cuota cuota) {
		getSession().delete(cuota);		
	}

	@Override
	public void delete(ValorCuota valorCuota) {
		getSession().delete(valorCuota);		
	}

	@Override
	public void delete(RegistroCuota registroCuota) {
		getSession().delete(registroCuota);		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cuota> listaCuotas() {
		return (List<Cuota>) getSession().createQuery("from Cuota").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ValorCuota> listaValorCuotas() {
		return (List<ValorCuota>) getSession().createQuery("from ValorCuota").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroCuota> listaRegistroCuotas(int idsocio, int anio) 
	{
		Criteria criteria = getSession().createCriteria(RegistroCuota.class);
		criteria.createAlias("cuota", "cuota");
		criteria.createAlias("cuota.socio", "socio");
		criteria.add(Restrictions.eq("cuota.anio", String.valueOf(anio)));
		criteria.add(Restrictions.eq("socio.oid", idsocio));
		
		if ( criteria.list().size() > 0 )
		{
			return (List<RegistroCuota>) criteria.list();
		}
		else
		{
			return null;
		}
	}

	@Override
	public Cuota findCuotaById(int id) {
		Criteria criteria = getSession().createCriteria(Cuota.class);
		criteria.add(Restrictions.eq("oid", id));
		return (Cuota) criteria.list().get(0);
	}

	@Override
	public ValorCuota findValorCuotaById(int id) {
		Criteria criteria = getSession().createCriteria(ValorCuota.class);
		criteria.add(Restrictions.eq("oid", id));
		return (ValorCuota) criteria.list().get(0);
	}

	@Override
	public RegistroCuota findRegistroCuotaById(int id) {
		Criteria criteria = getSession().createCriteria(RegistroCuota.class);
		criteria.add(Restrictions.eq("oid", id));
		return (RegistroCuota) criteria.list().get(0);
	}

	@Override
	public ValorCuota findValorCuota(ValorCuota obj) 
	{
		Criteria criteria = getSession().createCriteria(ValorCuota.class);
		criteria.createAlias("tipoSocio", "tipo");
		criteria.createAlias("categoriaSocio", "categoria");
		criteria.add(Restrictions.eq("tipo.oid", obj.getTipoSocio().getOid()));
		criteria.add(Restrictions.eq("categoria.oid", obj.getCategoriaSocio().getOid()));
		
		if ( criteria.list().size() > 0 )
		{
			return (ValorCuota) criteria.list().get(0);
		}
		else
		{
			return null;
		}
	}

	@Override
	public RegistroCuota findRegistroCuota(String anio, String mes, int idsocio) 
	{
		Criteria criteria = getSession().createCriteria(RegistroCuota.class);
		criteria.createAlias("cuota", "cuota");
		criteria.createAlias("cuota.socio", "socio");
		criteria.add(Restrictions.eq("cuota.anio", anio));
		criteria.add(Restrictions.eq("cuota.mes", mes));
		criteria.add(Restrictions.eq("socio.oid", idsocio));
		
		return (RegistroCuota) criteria.list().get(0);
	}
}
