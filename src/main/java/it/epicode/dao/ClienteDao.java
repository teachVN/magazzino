package it.epicode.dao;

import it.epicode.entities.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ClienteDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ClienteDao(){
        emf = Persistence.createEntityManagerFactory("magazzino");
        em = emf.createEntityManager();
    }

    public void inserisciCliente(Cliente c){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(c);
        et.commit();
    }

    public Cliente getById(int id){
        return em.find(Cliente.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Cliente c = getById(id);
        em.remove(c);
        et.commit();

    }
}
