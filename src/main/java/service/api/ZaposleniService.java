package service.api;

import java.util.List;

import model.Vozilo;
import model.Zaposleni;

public interface ZaposleniService {

	public List<Zaposleni> sviZaposleni();
	
	public String dodajZaposlenog(Zaposleni zaposleni) throws Exception;
	
	public boolean obrisiZaposlenog(Zaposleni zaposleni)throws Exception;
}
