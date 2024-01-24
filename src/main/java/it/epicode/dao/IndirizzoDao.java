package it.epicode.dao;

import it.epicode.entities.Cliente;
import it.epicode.entities.Indirizzo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class IndirizzoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public IndirizzoDao(){
        emf = Persistence.createEntityManagerFactory("magazzino");
        em = emf.createEntityManager();
    }

    public void inserisciIndirizzo(Indirizzo i){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(i);
        et.commit();
    }

    public Indirizzo getById(int id){
        return em.find(Indirizzo.class, id);
    }
}
