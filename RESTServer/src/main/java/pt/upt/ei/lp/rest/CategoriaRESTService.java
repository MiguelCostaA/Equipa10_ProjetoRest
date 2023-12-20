package pt.upt.ei.lp.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pt.upt.ei.lp.db.Categoria;
import pt.upt.ei.lp.db.CategoriaService;
import pt.upt.ei.lp.db.EstadoService;

@Path("/categoria")
public class CategoriaRESTService {
	private CategoriaService categoriaService = new CategoriaService();
	
	
	

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "REST Server : Olá, eu sou o controlador de Categorias";
	}

	
	@GET
	@Path("/getCategorias")
	public Response getCategorias() {
		List<Categoria> categorias = categoriaService.findAllCategoria();
		
		return Response.status(Response.Status.OK)
				.entity(categorias)
				.type(MediaType.APPLICATION_JSON)
				.build();	
	}
	
	@GET
	@Path("/getCategorias/{categoria}")
	public Response getCategoria(@PathParam("categoria") String categoria) {
		Categoria categoriaResponse = categoriaService.findCategoria(categoria);
		
		return Response.status(Response.Status.OK)
				.entity(categoriaResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@POST
	@Path("/addCategoria")
	public Response addCategoria(@FormParam("categoria")String categoria) {
		Categoria categoriaResponse = categoriaService.updateCategoria(categoria);
		
		return Response.status(Response.Status.CREATED)
				.entity(categoriaResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/updateCategoria")
	public Response updateCategoria(@FormParam("categoria")String categoria) {
		Categoria categoriaResponse = categoriaService.updateCategoria(categoria);
		
		return Response.status(Response.Status.OK)
				.entity(categoriaResponse)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@DELETE
	@Path("/deleteCategoria/{categoria}")
	public Response deleteCategoria(@PathParam("categoria") String categoria) {
		boolean categoriaRemoved = categoriaService.removeCategoria(categoria);
		
		return Response.status(Response.Status.OK)
				.entity(categoriaRemoved)
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
}