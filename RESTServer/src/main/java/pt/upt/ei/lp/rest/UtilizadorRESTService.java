package pt.upt.ei.lp.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import pt.upt.ei.lp.db.Tarefa;
import pt.upt.ei.lp.db.Utilizador;
import pt.upt.ei.lp.db.UtilizadorService;
@Path("/utilizador")
public class UtilizadorRESTService {
	private UtilizadorService utilizadorService = new UtilizadorService();
	
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "REST Server : Olá, eu sou o controlador de Utilizador";
    }

	
	@GET
	@Path("/getUtilizadores")
	public Response getUtilizadores() {
		List<Utilizador> utilizadores = utilizadorService.findAllUtilizador();
		
		return Response.status(Response.Status.OK)
				.entity(utilizadores)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getUtilizadores/{nome}")
	public Response getUtilizador(@PathParam("nome")String nome) {
		Utilizador utilizadorResponse = utilizadorService.findUtilizador(nome);
		
		return Response.status(Response.Status.OK)
				.entity(utilizadorResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	
	@POST
    @Path("/addUtilizador")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUtilizador(Utilizador utilizador) {
    	Utilizador utilizadorResponse = utilizadorService.updateUtilizador(utilizador.getNome(), utilizador.getEmail(), utilizador.getPassword());
    	
    	return Response.status(Response.Status.CREATED)
    			.entity(utilizadorResponse)
    			.type(MediaType.APPLICATION_JSON)
    			.build();
    }
	
	@PUT
    @Path("/updateUtilizador")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUtilizador(Utilizador utilizador) {
    	Utilizador utilizadorResponse = utilizadorService.updateUtilizador(utilizador.getNome(), utilizador.getEmail(), utilizador.getPassword());
    	
    	return Response.status(Response.Status.OK)
    			.entity(utilizadorResponse)
    			.type(MediaType.APPLICATION_JSON)
    			.build();
    }
	
	/*@POST
	@Path("/addUtilizador")
	public Response addUtilizador(@FormParam("nome") String nome,
	                               @FormParam("email") String email,
	                               @FormParam("password") String password) {
	    Utilizador utilizadorResponse = utilizadorService.updateUtilizador(nome, email, password);

	    return Response.status(Response.Status.CREATED)
	            .entity(utilizadorResponse)
	            .type(MediaType.APPLICATION_JSON)
	            .build();
	}*/
	
	/*@PUT
	@Path("/updateUtilizador")
	public Response updateUtilizador(@FormParam("nome") String nome, 
	                                 @FormParam("email") String email, 
	                                 @FormParam("password") String password) {
	    Utilizador utilizadorResponse = utilizadorService.updateUtilizador(nome, email, password);

	    return Response.status(Response.Status.OK)
	            .entity(utilizadorResponse)
	            .type(MediaType.APPLICATION_JSON)
	            .build();
	}*/
	
	@DELETE
	@Path("/deleteUtilizador/{nome}")
	public Response deleteUtilizador(@PathParam("nome") String nome) {
		boolean utilizadorRemoved = utilizadorService.removeUtilizador(nome);
		
		return Response.status(Response.Status.OK)
				.entity(utilizadorRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}