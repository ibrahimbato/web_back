package service.api;

import java.util.List;

import model.Vozilo;

public interface VoziloService {

	public List<Vozilo> svaVozila();
	
	public String dodajVozilo(Vozilo vozilo) throws Exception;
	
	public boolean obrisiVozilo(Vozilo vozilo);
	
}
