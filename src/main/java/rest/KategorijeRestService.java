package rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Kategorija;
import service.api.KategorijeService;

@Path("/kategorije")
public class KategorijeRestService {
	
	@Inject
	private KategorijeService kategorijeService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/sve")
	public Response svaVozila() {
		List<Kategorija> kategorije = kategorijeService.sveKategorije();
		return Response.ok(kategorije).header("Access-Control-Allow-Origin", "*").build();
	}
}
