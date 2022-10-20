package br.com.triumph.daos;

import br.com.triumph.models.Motorcycle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class MotorcyclesDAO {
    public List<Motorcycle> getAllMotorcycles(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Motorcycle> query = manager.createQuery("select m from Motorcycle m", Motorcycle.class);
        List<Motorcycle> motorcycles = query.getResultList();

        return motorcycles;
    }

    public Motorcycle getOneMotorcycle(Integer id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Motorcycle> query = manager.createQuery("select m from Motorcycle m where m.id = :idQuery", Motorcycle.class);
        query.setParameter("idQuery", id);
        Motorcycle motorcycle = query.getSingleResult();

        return motorcycle;
    }

    public Motorcycle createMotorcycle(Motorcycle newMotorcycle) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();//inicia a ALTERACAO/MODIFICACAO com o banco de dados
        manager.persist(newMotorcycle);
        manager.getTransaction().commit(); // o comit pega tudo o  que esta na transacao e autolriza a exceucao

        return newMotorcycle;
    }

    public Motorcycle updateMotorcycle(Motorcycle motoToBeUpdated) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(motoToBeUpdated);
        manager.getTransaction().commit();

        return motoToBeUpdated;
    }

    public void deleteMotorcycle(Integer id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Motorcycle> query = manager.createQuery("select m from Motorcycle m where m.id = :idDaQuery", Motorcycle.class);
        query.setParameter("idDaQuery", id);
        Motorcycle motoToBeUpdated = query.getSingleResult();
        manager.getTransaction().begin();
        manager.remove(motoToBeUpdated);
        manager.getTransaction().commit();
    }
}