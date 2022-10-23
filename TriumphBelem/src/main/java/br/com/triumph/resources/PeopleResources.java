package br.com.triumph.resources;


import br.com.triumph.models.People;
import br.com.triumph.services.PeopleService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/people")
public class PeopleResources {

    private PeopleService peopleService = new PeopleService();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //serializacao
    public List<People> getAllPeople() {

        List<People> list = peopleService.getAllPeople();

        return list;
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public People getOnePeople(@PathParam("id") Integer id) {

        return peopleService.getOnePeople(id);
    }

    @GET
    @Path("/query/name")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<People> getOnePeopleByName(@QueryParam("name") String name){
        return peopleService.getOnePeopleByName(name);
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public People createPeople(People newPeople){

        People pessoa = peopleService.createPeople(newPeople);

        return pessoa;
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public People updatePeople(@PathParam("id") Integer id, People dataToBeUpdated) { //informacoes a serem atualizadas

        People peopleUpdated = peopleService.updatePeople(id, dataToBeUpdated);

        return peopleUpdated;

    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void deletePeople(@PathParam("id") Integer id) {

       peopleService.deletePeople(id);

    }
}


