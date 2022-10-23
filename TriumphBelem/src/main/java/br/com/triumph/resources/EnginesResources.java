package br.com.triumph.resources;

import br.com.triumph.models.Engine;
import br.com.triumph.models.Motorcycle;
import br.com.triumph.services.EngineService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/engines")
public class EnginesResources {

    private EngineService engineService = new EngineService();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //serializacao
    public List<Engine> getAllEngines() {

        List<Engine> list = engineService.getAllEngines();

        return list;
    }

    @GET
    @Path("/query/name")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Engine> getEngineByName(@QueryParam("name") String name){

       return engineService.getOneEngineByName(name);
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Engine getOneEngine(@PathParam("id") Integer id) {

        return engineService.getOneEngine(id);
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Engine createEngine(Engine newEngine) {

        Engine engine = engineService.createEngine(newEngine);

        return engine;
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Engine updateEngine(@PathParam("id") Integer id, Engine dataEngineToUpdate) { //informacoes a serem atualizadas

        Engine engineUpdated = engineService.updateEngine(id, dataEngineToUpdate);

        return engineUpdated;
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void deleteEngine(@PathParam("id") Integer id) {

        engineService.deleteEngine(id);
    }
}
