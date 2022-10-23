package br.com.triumph.daos;

import br.com.triumph.models.Engine;
import br.com.triumph.models.Motorcycle;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EnginesDAO {

    public List<Engine> getAllEngines(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Engine> query = manager.createQuery("select m from Engine m", Engine.class);
        List<Engine> engines = query.getResultList();

        return engines;
    }


    public Engine getOneEngine(Integer id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Engine> query = manager.createQuery("select m from Engine m where m.id = :idQuery", Engine.class);
        query.setParameter("idQuery", id);
        Engine engine = query.getSingleResult();

        return engine;
    }

    public List<Engine> getOneEngineByName(String engineName){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Engine> query = manager.createQuery("select m from Engines m where m.name like: nameQuery", Engine.class);
        query.setParameter("nameQuery", "%" + engineName + "%"); //Enterpolaçao
        List <Engine> engineList = query.getResultList();

        return engineList;
    }


    public Engine createEngine(Engine newEngine) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();//inicia a ALTERACAO/MODIFICACAO com o banco de dados
        manager.persist(newEngine);
        manager.getTransaction().commit(); // o comit pega tudo o  que esta na transacao e autolriza a exceucao

        return newEngine;
    }

    public Engine updateEngine (Engine engineToBeUpdated) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(engineToBeUpdated);
        manager.getTransaction().commit();

        return engineToBeUpdated;
    }

    public void deleteEngine(Integer id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TriumphPU");
        EntityManager manager = factory.createEntityManager();
        TypedQuery<Engine> query = manager.createQuery("select m from Engine m where m.id = :idQuery", Engine.class);
        query.setParameter("idQuery", id);
        Engine engineToBeDeleted = query.getSingleResult();
        manager.getTransaction().begin();
        manager.remove(engineToBeDeleted);
        manager.getTransaction().commit();
    }
}



