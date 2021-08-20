package service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Vozilo;
import model.Zaposleni;
import service.api.VoziloService;

@Stateless
public class VoziloServiceImpl implements VoziloService{
	
	@Inject
	private Logger log;
	 
	@Inject 
	private EntityManager em;
	
	public List<Vozilo> svaVozila(){
		return em.createNamedQuery(Vozilo.GET_ALL, Vozilo.class).getResultList();
	}
	
	public String dodajVozilo(Vozilo vozilo) throws Exception {
		for(Vozilo i: svaVozila()) {
			if(i.getId() == vozilo.getId()) {
				i = vozilo;
				em.merge(i);
				log.info("Azuriranje vozila:" + vozilo.getModel());
				return "Azurirano";
			}
		}
		log.info("Dodavanje vozila:" + vozilo.getModel());
		
		em.merge(vozilo);
		return "Dodato";
	}
	
	public boolean obrisiVozilo(Vozilo vozilo) {
		int voziloDelete = em.createNamedQuery(Vozilo.DELETE_VOZILO).setParameter("id", vozilo.getId())
				.executeUpdate();
		if (voziloDelete == 0) {
			return true;
		}
		return false;
	}
}
