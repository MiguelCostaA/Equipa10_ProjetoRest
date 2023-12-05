package cenas;

import java.util.List;

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

import upt.Categoria;
import upt.CategoriaService;

@Path("/categoria")
public class CategoriaRESTService {
    private CategoriaService cts = new CategoriaService();
    
    // Método para obter uma saudação simples do controlador de Categorias
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(Request a) {
        return "REST Server : Olá, eu sou o controlador de Categorias";
    }
    
    // Método para obter todas as Categorias
    @GET
    @Path("/getCategorias")
    public Response getCategorias() {
        List<Categoria> categorias = cts.findAllCategoria();
        
        return Response.status(Response.Status.OK)
                .entity(categorias)
                .type(MediaType.APPLICATION_JSON)
                .build();    
    }
    
    // Método para obter uma Categoria específica com base no nome
    @GET
    @Path("/getCategorias/{categoria}")
    public Response getCategoria(@PathParam("categoria") String categoria) {
        Categoria categoriaResponse = cts.findCategoria(categoria);
        
        return Response.status(Response.Status.OK)
                .entity(categoriaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para adicionar uma nova Categoria
    @POST
    @Path("/addCategoria")
    public Response addCategoria(String categoria) {
        Categoria categoriaResponse = cts.updateCategoria(categoria);
        
        return Response.status(Response.Status.CREATED)
                .entity(categoriaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para atualizar uma Categoria existente
    @PUT
    @Path("/updateCategoria")
    public Response updateCategoria(String categoria) {
        Categoria categoriaResponse = cts.updateCategoria(categoria);
        
        return Response.status(Response.Status.OK)
                .entity(categoriaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para eliminar uma Categoria com base no nome
    @DELETE
    @Path("/deleteCategoria/{categoria}")
    public Response deleteCategoria(@PathParam("categoria") String categoria) {
        boolean categoriaRemoved = cts.removeCategoria(categoria);
        
        return Response.status(Response.Status.OK)
                .entity(categoriaRemoved)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
