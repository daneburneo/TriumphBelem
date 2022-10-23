package br.com.triumph.resources;

import br.com.triumph.models.Contact;
import br.com.triumph.models.Reserve;
import br.com.triumph.services.ContactService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/contacts")
public class ContactsResources {

    private ContactService contactService = new ContactService();

    @GET
    @Produces(value = MediaType.APPLICATION_JSON) //serializacao
    public List<Contact> getAllContacts(){

        List<Contact> list = contactService.getAllContacts();

        return list;
    }

    @GET
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public Contact getOneContact(@PathParam("id") Integer id) { return contactService.getOneContact(id); }

    @GET
    @Path("/query/name")
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Contact> getOneContactByName(String name){ return contactService.getOneContactByname(name); }


    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Contact createContact(Contact newContact) {

        Contact contact = contactService.createContact(newContact);

        return contact;
    }

    @PUT
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    @Consumes(value = MediaType.APPLICATION_JSON)
    public Contact updateContact(@PathParam("id") Integer id, Contact dataToBeUpdated) { //informacoes a serem atualizadas

       Contact contact = contactService.updateContact(id, dataToBeUpdated);

        return contact;
    }

    @DELETE
    @Path("/{id}")
    @Produces(value = MediaType.APPLICATION_JSON)
    public void deleteContact(@PathParam("id") Integer id) {

        contactService.deleteContact(id);
    }
}

