package it.epicode.dao;

import it.epicode.entities.Cliente;
import it.epicode.entities.Ordine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class OrdineDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public OrdineDao(){
        emf = Persistence.createEntityManagerFactory("magazzino");
        em = emf.createEntityManager();
    }

    public void inserisciOrdine(Ordine c){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(c);
        et.commit();
    }

    public Ordine getById(int id){
        return em.find(Ordine.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Ordine c = getById(id);
        em.remove(c);
        et.commit();

    }
}
