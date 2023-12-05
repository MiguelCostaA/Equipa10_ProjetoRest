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

import upt.Estado;
import upt.EstadoService;

@Path("/estado")
public class EstadoRESTService {
    private EstadoService ets = new EstadoService();
    
    // Método para obter uma saudação simples do controlador de Estados
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(Request a) {
        return "REST Server : Olá, eu sou o controlador de Estados";
    }
    
    // Método para obter todos os Estados
    @GET
    @Path("/getEstados")
    public Response getEstados() {
        List<Estado> estados = ets.findAllEstado();
        
        return Response.status(Response.Status.OK)
                .entity(estados)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para obter um Estado específico com base no nome
    @GET
    @Path("/getEstados/{estado}")
    public Response getEstado(@PathParam("estado") String estado) {
        Estado estadoResponse = ets.findEstado(estado);
        
        return Response.status(Response.Status.OK)
                .entity(estadoResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para adicionar um novo Estado
    @POST
    @Path("/addEstado")
    public Response addEstado(String estado) {
        Estado estadoResponse = ets.updateEstado(estado);
        
        return Response.status(Response.Status.CREATED)
                .entity(estadoResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para atualizar um Estado existente
    @PUT
    @Path("/updateEstado")
    public Response updateEstado(String estado) {
        Estado estadoResponse = ets.updateEstado(estado);
        
        return Response.status(Response.Status.OK)
                .entity(estadoResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para eliminar um Estado com base no nome
    @DELETE
    @Path("/deleteEstado/{estado}")
    public Response deleteEstado(@PathParam("estado") String estado) {
        boolean estadoRemoved = ets.removeEstado(estado);
        
        return Response.status(Response.Status.OK)
                .entity(estadoRemoved)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
