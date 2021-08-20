package service.impl;

import java.util.List;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import model.Zaposleni;
import service.api.ZaposleniService;

@Stateless
public class ZaposleniServiceImpl implements ZaposleniService {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public List<Zaposleni> sviZaposleni() {
		return em.createNamedQuery(Zaposleni.GET_ALL, Zaposleni.class).getResultList();
	}

	public String dodajZaposlenog(Zaposleni zaposleni) throws Exception {
	
		for(Zaposleni z: sviZaposleni()) {
			if(z.getId() == zaposleni.getId()) {
				z = zaposleni;
				em.merge(z);
				log.info("Azuriranje zaposlenog:" + zaposleni.getIme() + " " + zaposleni.getPrezime());
				return "Azuriran";
			}
		}
		log.info("Dodavanje zaposlenog:" + zaposleni.getIme() + " " + zaposleni.getPrezime());
		em.merge(zaposleni);
		return "Dodat";
	}

	public boolean obrisiZaposlenog(Zaposleni zaposleni) {
		int zaposleniDelete = em.createNamedQuery(Zaposleni.DELETE_ZAPOSLENI).setParameter("id", zaposleni.getId())
				.executeUpdate();
		if (zaposleniDelete == 0) {
			return true;
		}
		return false;
	}

}
