package br.com.triumph.services;

import br.com.triumph.daos.ContactsDAO;
import br.com.triumph.models.Contact;

import java.util.List;

public class ContactService {

    private ContactsDAO contactsDAO = new ContactsDAO();

    public List<Contact> getAllContacts() {

        List<Contact> list = contactsDAO.getAllContacts();

        return list;
    }

    public Contact getOneContact(Integer id){
        return contactsDAO.getOneContact(id);
    }

    public List<Contact> getOneContactByname(String name){
        return contactsDAO.getOneContactByName(name);
    }

    public Contact updateContact(Integer id, Contact newContact) {

        if (validateContact(newContact) == false) {
            throw new RuntimeException("Unable to update data");
        }

        Contact contact1 = contactsDAO.getOneContact(id);
        contact1.setContact(newContact.getContact());
        Contact contact = contactsDAO.updateContact(contact1);

        return contact;
    }

    public Contact createContact(Contact newContact) {
        if (newContact.getId() == null) {
            throw new RuntimeException("Unable to update data, Please, go into the Store and try to update");
        }
        if (newContact.getContact() == null) {
            throw new RuntimeException("Unable to update data. The value cannot be 'Null'. PLease, enter a valid value");
        }

        Contact contact = contactsDAO.createContact(newContact);
        return contact;
    }

    public void deleteContact(Integer id) {

        contactsDAO.deleteContact(id);
    }

    private Boolean validateContact(Contact contact) {

        boolean validate = true;

        if (contact.getContact() != null) {
            validate = false;
        }

        if (contact.getId() == null) {
            validate = false;
        }
        return validate;
    }
}
