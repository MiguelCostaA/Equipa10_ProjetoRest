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

import upt.Tarefa;
import upt.TarefaService;

@Path("/tarefa")
public class TarefaRESTService {
    private TarefaService tfs = new TarefaService();
    
    // Método para obter uma saudação simples do controlador de Tarefas
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(Request a) {
        return "REST Server : Olá, eu sou o controlador de Tarefas";
    }
    
    // Método para obter todas as Tarefas
    @GET
    @Path("/getTarefas")
    public Response getTarefas() {
        List<Tarefa> tarefas = tfs.findAllTarefa();
        
        return Response.status(Response.Status.OK)
                .entity(tarefas)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para obter uma Tarefa específica com base no título
    @GET
    @Path("/getTarefas/{titulo}")
    public Response getTarefa(@PathParam("titulo") String titulo) {
        Tarefa tarefaResponse = tfs.findTarefa(titulo);
        
        return Response.status(Response.Status.OK)
                .entity(tarefaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para adicionar uma nova Tarefa
    @POST
    @Path("/addTarefa")
    public Response addTarefa(String titulo, String descricao, String dataConclusao, String prioridade) {
        Tarefa tarefaResponse = tfs.updateTarefa(titulo, descricao, dataConclusao, prioridade);
        
        return Response.status(Response.Status.CREATED)
                .entity(tarefaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para atualizar uma Tarefa existente
    @PUT
    @Path("/updateTarefa")
    public Response updateTarefa(String titulo, String descricao, String dataConclusao, String prioridade) {
        Tarefa tarefaResponse = tfs.updateTarefa(titulo, descricao, dataConclusao, prioridade);
        
        return Response.status(Response.Status.OK)
                .entity(tarefaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    // Método para eliminar uma Tarefa com base no título
    @DELETE
    @Path("/deleteTarefa/{titulo}")
    public Response deleteTarefa(@PathParam("titulo") String titulo) {
        boolean tarefaRemoved = tfs.removeTarefa(titulo);
        
        return Response.status(Response.Status.OK)
                .entity(tarefaRemoved)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
