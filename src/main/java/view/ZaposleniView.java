package view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.Zaposleni;
import service.api.ZaposleniService;

@Named
@ViewScoped
public class ZaposleniView implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ZaposleniService zaposleniService;
	
	private List<Zaposleni> zaposleniLista;
	
	private Zaposleni zaposleni;
	
	@PostConstruct
	public void initNewCandidate() {
		zaposleni = new Zaposleni();
		zaposleniLista = zaposleniService.sviZaposleni();
	}
	
	public void dodajNovogZaposlenog() throws Exception{
		try {
			zaposleniService.dodajZaposlenog(zaposleni);
			zaposleni = new Zaposleni();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO,"Dodat!","Uspjesno dodat zaposleni!");
			facesContext.addMessage(null, m);
			zaposleniLista = zaposleniService.sviZaposleni();
		} catch (Exception e) {
			// TODO: handle exception
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Nije dodat!","Dodavanje neuspjesno!");
			facesContext.addMessage(null, m);
		}
	}
}
