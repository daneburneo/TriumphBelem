package br.com.triumph.daos;

import br.com.triumph.models.People;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class PeopleDAO {

    public List<People> getAllPeople() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<People> query = manager.createQuery("select m from People m", People.class);
        List<People> people = query.getResultList();

        return people;
    }

    public People getOnePeople(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<People> query = manager.createQuery("select m from People m where m.id = :idQuery", People.class);
        query.setParameter("idQuery", id);
        People people = query.getSingleResult();

        return people;
    }

    public People createPeople(People newPeople) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();//inicia a ALTERACAO/MODIFICACAO com o banco de dados
        manager.persist(newPeople);
        manager.getTransaction().commit(); // o comit pega tudo o  que esta na transacao e autolriza a exceucao

        return newPeople;
    }
    public People updatePeople(People pessoaASerAtualizada) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(pessoaASerAtualizada);
        manager.getTransaction().commit();

        return pessoaASerAtualizada;
    }

    public void deletePeople(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<People> query = manager.createQuery("select m from People m where m.id = :idDaQuery", People.class);
        query.setParameter("idDaQuery", id);
        People peopleToBeDeleted = query.getSingleResult();
        manager.getTransaction().begin();
        manager.remove(peopleToBeDeleted);
        manager.getTransaction().commit();
    }
}



