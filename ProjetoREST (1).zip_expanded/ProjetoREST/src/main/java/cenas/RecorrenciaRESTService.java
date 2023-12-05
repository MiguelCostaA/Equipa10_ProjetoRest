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

import upt.Recorrencia;
import upt.RecorrenciaService;

@Path("/recorrencia")
public class RecorrenciaRESTService {
    private RecorrenciaService rts = new RecorrenciaService();
    
    // Método para obter uma saudação simples do controlador de Recorrências
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(Request a) {
        return "REST Server : Olá, eu sou o controlador de Recorrências";
    }
    
    // Método para obter todas as Recorrências
    @GET
    @Path("/getRecorrencias")
    public Response getRecorrencias() {
        List<Recorrencia> recorrencias = rts.findAllRecorrencia();
        
        return Response.status(Response.Status.OK)
                .entity(recorrencias)
                .type(MediaType.APPLICATION_JSON)
                .build();    
    }
    
    // Método para obter uma Recorrência específica com base no nome
    @GET
    @Path("/getRecorrencias/{recorrencia}")
    public Response getRecorrencia(@PathParam("recorrencia") String recorrencia) {
        Recorrencia recorrenciaResponse = rts.findRecorrencia(recorrencia);
        
        return Response.status(Response.Status.OK)
                .entity(recorrenciaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para adicionar uma nova Recorrência
    @POST
    @Path("/addRecorrencia")
    public Response addRecorrencia(String recorrencia) {
        Recorrencia recorrenciaResponse = rts.updateRecorrencia(recorrencia);
        
        return Response.status(Response.Status.CREATED)
                .entity(recorrenciaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para atualizar uma Recorrência existente
    @PUT
    @Path("/updateRecorrencia")
    public Response updateRecorrencia(String recorrencia) {
        Recorrencia recorrenciaResponse = rts.updateRecorrencia(recorrencia);
        
        return Response.status(Response.Status.OK)
                .entity(recorrenciaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para eliminar uma Recorrência com base no nome
    @DELETE
    @Path("/deleteRecorrencia/{recorrencia}")
    public Response deleteRecorrencia(@PathParam("recorrencia") String recorrencia) {
        boolean recorrenciaRemoved = rts.removeRecorrencia(recorrencia);
        
        return Response.status(Response.Status.OK)
                .entity(recorrenciaRemoved)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
