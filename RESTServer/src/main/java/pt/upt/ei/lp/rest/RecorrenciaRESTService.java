package pt.upt.ei.lp.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

import pt.upt.ei.lp.db.Recorrencia;
import pt.upt.ei.lp.db.RecorrenciaService;

@Path("/recorrencia")
public class RecorrenciaRESTService {
private RecorrenciaService recorrenciaService = new RecorrenciaService();

	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Olá, eu sou o controlador de Recorrências";
	}
	
	@GET
	@Path("/getRecorrencias")
	public Response getRecorrencias() {
		List<Recorrencia> recorrencias = recorrenciaService.findAllRecorrencia();
		
		return Response.status(Response.Status.OK)
				.entity(recorrencias)
				.type(MediaType.APPLICATION_JSON)
				.build();	
	}
	
	@GET
	@Path("/getRecorrencias/{recorrencia}")
	public Response getRecorrencia(@PathParam("recorrencia") String recorrencia) {
		Recorrencia recorrenciaResponse = recorrenciaService.findRecorrencia(recorrencia);
		
		return Response.status(Response.Status.OK)
				.entity(recorrenciaResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addRecorrencia")
	public Response addRecorrencia(String recorrencia) {
		Recorrencia recorrenciaResponse = recorrenciaService.updateRecorrencia(recorrencia);
		
		return Response.status(Response.Status.CREATED)
				.entity(recorrenciaResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateRecorrencia")
	public Response updateRecorrencia(String recorrencia) {
		Recorrencia recorrenciaResponse = recorrenciaService.updateRecorrencia(recorrencia);
		
		return Response.status(Response.Status.OK)
				.entity(recorrenciaResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteRecorrencia/{recorrencia}")
	public Response deleteRecorrencia(@PathParam("recorrencia") String recorrencia) {
		boolean recorrenciaRemoved = recorrenciaService.removeRecorrencia(recorrencia);
		
		return Response.status(Response.Status.OK)
				.entity(recorrenciaRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}