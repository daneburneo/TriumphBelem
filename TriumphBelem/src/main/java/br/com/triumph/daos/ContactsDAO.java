package br.com.triumph.daos;

import br.com.triumph.models.Contact;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ContactsDAO {
    public List<Contact> getAllContacts() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Contact> query = manager.createQuery("select m from Contact m", Contact.class);
        List<Contact> contacts = query.getResultList();

        return contacts;
    }
    public Contact getOneContact(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Contact> query = manager.createQuery("select m from Contact m where m.id = :idQuery", Contact.class);
        query.setParameter("idQuery", id);
        Contact contact = query.getSingleResult();

        return contact;
    }

    public List<Contact> getOneContactByName(String name){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Contact> query = manager.createQuery("select m from Contact m where m.name like: nameQuery", Contact.class);
        query.setParameter("nameQuery", name);
        List<Contact> contactList = query.getResultList();

        return contactList;
    }

    public Contact createContact(Contact newContact) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();//inicia a ALTERACAO/MODIFICACAO com o banco de dados
        manager.persist(newContact);
        manager.getTransaction().commit(); // o comit pega tudo o  que esta na transacao e autolriza a exceucao

        return newContact;
    }

    public Contact updateContact(Contact contactToBeUpdated) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(contactToBeUpdated);
        manager.getTransaction().commit();

        return contactToBeUpdated;
    }

    public void deleteContact(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Contact> query = manager.createQuery("select m from Contact m where m.id = :idDaQuery", Contact.class);
        query.setParameter("idDaQuery", id);
        Contact contactToBeDeleted = query.getSingleResult();
        manager.getTransaction().begin();
        manager.remove(contactToBeDeleted);
        manager.getTransaction().commit();
    }
}

