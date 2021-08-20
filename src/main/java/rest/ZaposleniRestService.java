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


import model.Zaposleni;
import service.api.ZaposleniService;

@Path("/zaposleni")
@RequestScoped
public class ZaposleniRestService {

	@Inject
	private ZaposleniService zaposleniService;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dodajZaposlenog")
	public String dodajZaposlenog(Zaposleni zaposleni) {

		try {
			if (zaposleniService.dodajZaposlenog(zaposleni).equalsIgnoreCase("Dodat")) {
				return "Uspjesno dodat zaposleni!";
			} else {
				return "Uspjesno azuriran zaposleni!";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Greska!";
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/svi")
	public Response sviZaposleni() {
		List<Zaposleni> zaposleni = zaposleniService.sviZaposleni();
		return Response.ok(zaposleni).header("Access-Control-Allow-Origin", "*").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/obrisiZaposlenog")
	public String obrisiZaposlenog(Zaposleni zaposleni) {
		try {
			zaposleniService.obrisiZaposlenog(zaposleni);
			String message = "Uspjesno obrisan zaposleni!";
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			String message = "Greska prilikom brisanja zaposlenog!";
			return message;
		}
	}

}
