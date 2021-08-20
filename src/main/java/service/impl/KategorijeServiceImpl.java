package service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Kategorija;
import service.api.KategorijeService;

@Stateless
public class KategorijeServiceImpl implements KategorijeService{
	@Inject 
	private EntityManager em;
	
	public List<Kategorija> sveKategorije(){
		return em.createNamedQuery(Kategorija.GET_ALL, Kategorija.class).getResultList();
	}

}
