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

import upt.Utilizador;
import upt.UtilizadorService;

@Path("/utilizador")
public class UtilizadorRESTService {
    private UtilizadorService uts = new UtilizadorService();
    
    // Método para obter uma saudação simples do controlador de Utilizadores
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(Request a) {
        return "REST Server : Olá, eu sou o controlador de Utilizadores";
    }
    
    // Método para obter todos os Utilizadores
    @GET
    @Path("/getUtilizadores")
    public Response getUtilizadores() {
        List<Utilizador> utilizadores = uts.findAllUtilizador();
        
        return Response.status(Response.Status.OK)
                .entity(utilizadores)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para obter um Utilizador específico com base no nome
    @GET
    @Path("/getUtilizadores/{nome}")
    public Response getUtilizador(@PathParam("nome") String nome) {
        Utilizador utilizadorResponse = uts.findUtilizador(nome);
        
        return Response.status(Response.Status.OK)
                .entity(utilizadorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para adicionar um novo Utilizador
    @POST
    @Path("/addUtilizador")
    public Response addUtilizador(String nome, String email, String password) {
        Utilizador utilizadorResponse = uts.updateUtilizador(nome, email, password);
        
        return Response.status(Response.Status.CREATED)
                .entity(utilizadorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para atualizar um Utilizador existente
    @PUT
    @Path("/updateUtilizador")
    public Response updateUtilizador(String nome, String email, String password) {
        Utilizador utilizadorResponse = uts.updateUtilizador(nome, email, password);
        
        return Response.status(Response.Status.OK)
                .entity(utilizadorResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para eliminar um Utilizador com base no nome
    @DELETE
    @Path("/deleteUtilizador/{nome}")
    public Response deleteUtilizador(@PathParam("nome") String nome) {
        boolean utilizadorRemoved = uts.removeUtilizador(nome);
        
        return Response.status(Response.Status.OK)
                .entity(utilizadorRemoved)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
