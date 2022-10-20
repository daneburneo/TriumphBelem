package br.com.triumph.resources; //nome de pacote sempre em minusculo.


import br.com.triumph.models.Motorcycle;
import br.com.triumph.services.MotorcycleService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/motorcycles")
public class MotorcyclesResources {

    private MotorcycleService motorcycleService = new MotorcycleService();


    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //serializacao
    public List<Motorcycle> getAllMotorcycles() {

        List<Motorcycle> list = motorcycleService.getAllMotorcycles();

        return list;
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Motorcycle getOneMotorcycle(@PathParam("id") Integer id) {

        return null;
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Motorcycle createMotorcycle(Motorcycle newMotorcycle) {

        Motorcycle newMoto = motorcycleService.createMotorcycle(newMotorcycle);

        return newMoto;
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Motorcycle updateMotorcycle(@PathParam("id") Integer id, Motorcycle dataToBeUpdated) { //informacoes a serem atualizadas

        Motorcycle updatedMoto = motorcycleService.updateMotorcycle(id, dataToBeUpdated);

        return updatedMoto;
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void deleteMotorcycle(@PathParam("id") Integer id) {

        motorcycleService.deleteMotorcycle(id);
    }
}