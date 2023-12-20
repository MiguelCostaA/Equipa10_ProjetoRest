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
import pt.upt.ei.lp.db.TarefaService;

@Path("/tarefa")
public class TarefaRESTService {

    private TarefaService tarefaService = new TarefaService();

   
    

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "REST Server : Olá, eu sou o controlador de Tarefas";
    }

    @GET
    @Path("/getTarefas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTarefas() {
        List<Tarefa> tarefas = tarefaService.findAllTarefa();

        return Response.status(Response.Status.OK)
                .entity(tarefas)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("/getTarefas/{titulo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTarefa(@PathParam("titulo") String titulo) {
        Tarefa tarefaResponse = tarefaService.findTarefa(titulo);

        return Response.status(Response.Status.OK)
                .entity(tarefaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    @POST
    @Path("/addTarefa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTarefa(Tarefa tarefa) {
    	Tarefa tarefaResponse = tarefaService.updateTarefa(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataConclusao(), tarefa.getPrioridade());
    	
    	return Response.status(Response.Status.CREATED)
    			.entity(tarefaResponse)
    			.type(MediaType.APPLICATION_JSON)
    			.build();
    }
    
    @PUT
    @Path("/updateTarefa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTarefa(Tarefa tarefa) {
    	Tarefa tarefaResponse = tarefaService.updateTarefa(tarefa.getTitulo(), tarefa.getDescricao(), tarefa.getDataConclusao(), tarefa.getPrioridade());
    	
    	return Response.status(Response.Status.CREATED)
    			.entity(tarefaResponse)
    			.type(MediaType.APPLICATION_JSON)
    			.build();
    }
    
    /*
    @POST
    @Path("/addTarefa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTarefa(
            @FormParam("titulo") String titulo,
            @FormParam("descricao") String descricao,
            @FormParam("dataConclusao") String dataConclusao,
            @FormParam("prioridade") String prioridade) {
        Tarefa tarefaResponse = tarefaService.updateTarefa(titulo, descricao, dataConclusao, prioridade);

        return Response.status(Response.Status.CREATED)
                .entity(tarefaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }*/

    /*
    @PUT
    @Path("/updateTarefa")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateTarefa(
            @FormParam("titulo") String titulo,
            @FormParam("descricao") String descricao,
            @FormParam("dataConclusao") String dataConclusao,
            @FormParam("prioridade") String prioridade) {
        Tarefa tarefaResponse = tarefaService.updateTarefa(titulo, descricao, dataConclusao, prioridade);

        return Response.status(Response.Status.OK)
                .entity(tarefaResponse)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }*/

    @DELETE
    @Path("/deleteTarefa/{titulo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTarefa(@PathParam("titulo") String titulo) {
        boolean tarefaRemoved = tarefaService.removeTarefa(titulo);

        return Response.status(Response.Status.OK)
                .entity(tarefaRemoved)
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}