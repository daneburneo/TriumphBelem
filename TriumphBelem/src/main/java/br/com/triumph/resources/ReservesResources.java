package br.com.triumph.resources;

import br.com.triumph.models.Reserve;
import br.com.triumph.services.ReserveService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/reserves")
public class ReservesResources {

    private ReserveService reserveService = new ReserveService();


    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //serializacao
    public List<Reserve> getAllReserves() {

        List<Reserve> list = reserveService.getAllReserves();

        return list;
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Reserve getOneReserve(@PathParam("id") Integer id) {

        return reserveService.getOneReserve(id);
    }

    @GET
    @Path("/query/name")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Reserve> getOneReserveByName(String name){
        return reserveService.getOneReserveByName(name);
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Reserve createReserve(Reserve newReserve) {

        Reserve reserve = reserveService.createReserve(newReserve);

        return reserve;
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Reserve updateReserve(@PathParam("id") Integer id, Reserve dataToBeUpdated) { //informacoes a serem atualizadas

        Reserve updatedReserve = reserveService.updateReserve(id, dataToBeUpdated);

        return updatedReserve;
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void deleteReserve(@PathParam("id") Integer id) {

        reserveService.deleteReserve(id);
    }
}

