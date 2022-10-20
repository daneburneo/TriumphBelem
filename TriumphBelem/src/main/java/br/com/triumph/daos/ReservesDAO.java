package br.com.triumph.daos;


import br.com.triumph.models.Reserve;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class ReservesDAO {

    public List<Reserve> getAllReserves(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Reserve> query = manager.createQuery("select m from Reserve m", Reserve.class);
        List<Reserve> reserves = query.getResultList();

        return reserves;
    }

    public Reserve getOneReserve(Integer id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Reserve> query = manager.createQuery("select m from Reserve m where m.id = :idQuery", Reserve.class);
        query.setParameter("idQuery", id);
        Reserve reserves = query.getSingleResult();

        return reserves;
    }

    public Reserve createReserve(Reserve newReserve) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();//inicia a ALTERACAO/MODIFICACAO com o banco de dados
        manager.persist(newReserve);
        manager.getTransaction().commit(); // o comit pega tudo o  que esta na transacao e autolriza a exceucao

        return newReserve;
    }

    public Reserve updateReserve (Reserve reserveToBeUpdated) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(reserveToBeUpdated);
        manager.getTransaction().commit();

        return reserveToBeUpdated;
    }

    public void deleteReserve(Integer id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Reserve> query = manager.createQuery("select m from Reserve m where m.id = :idQuery", Reserve.class);
        query.setParameter("idQuery", id);
        Reserve reserveToBeDeleted = query.getSingleResult();
        manager.getTransaction().begin();
        manager.remove(reserveToBeDeleted);
        manager.getTransaction().commit();
    }
}

