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

import pt.upt.ei.lp.db.Estado;
import pt.upt.ei.lp.db.EstadoService;

@Path("/estado")
public class EstadoRESTService {
	private EstadoService estadoService = new EstadoService();
	
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(Request a) {
		return "REST Server : Olá, eu sou o controlador de Estados";
	}
	
	@GET
	@Path("/getEstados")
	public Response getEstados() {
		List<Estado> estados = estadoService.findAllEstado();
		
		return Response.status(Response.Status.OK)
				.entity(estados)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@GET
	@Path("/getEstados/{estado}")
	public Response getEstado(@PathParam("estado")String estado) {
		Estado estadoResponse = estadoService.findEstado(estado);
		
		return Response.status(Response.Status.OK)
				.entity(estadoResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addEstado")
	public Response addEstado(String estado) {
		Estado estadoResponse = estadoService.updateEstado(estado);
		
		return Response.status(Response.Status.CREATED)
				.entity(estadoResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateEstado")
	public Response updateEstado(String estado) {
		Estado estadoResponse = estadoService.updateEstado(estado);
		
		return Response.status(Response.Status.OK)
				.entity(estadoResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteEstado/{estado}")
	public Response deleteEstado(@PathParam("estado")String estado) {
		boolean estadoRemoved = estadoService.removeEstado(estado);
		
		return Response.status(Response.Status.OK)
				.entity(estadoRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}