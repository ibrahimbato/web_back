package rest;

import java.util.List;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Vozilo;
import model.Zaposleni;
import service.api.VoziloService;

@Path("/vozilo")
@RequestScoped
public class VoziloRestService {
	
	@Inject
	private VoziloService voziloService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sva")
	public Response svaVozila() {
		List<Vozilo> vozila = voziloService.svaVozila();
		return Response.ok(vozila).header("Access-Control-Allow-Origin", "*").build();
	}
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dodajVozilo")
	public String dodajVozilo(Vozilo vozilo) {
		try {
			if (voziloService.dodajVozilo(vozilo).equalsIgnoreCase("Dodato")) {
				return "Uspjesno dodato vozilo!";
			} else {
				return "Uspjesno azurirano vozilo!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Greska!";
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obrisiVozilo")
	public String obrisiVozilo(Vozilo vozilo) {
		try {
			voziloService.obrisiVozilo(vozilo);
			String message = "Uspjesno obrisano vozilo!";
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			String message = "Greska prilikom brisanja vozila!";
			return message;
		}
	}

	
}
