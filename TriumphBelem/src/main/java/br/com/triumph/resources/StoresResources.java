package br.com.triumph.resources;


import br.com.triumph.models.Motorcycle;
import br.com.triumph.services.StoreService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/store")
public class StoresResources {

    private StoreService storeService = new StoreService();

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Motorcycle registerNewPromo(@PathParam("id") Integer id, Motorcycle infoNewPromo) {

        Motorcycle motoFinal = storeService.registerNewPromo(id, infoNewPromo);

        return motoFinal;
    }
}
