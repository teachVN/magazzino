package it.epicode.dao;

import it.epicode.entities.Ordine;
import it.epicode.entities.Prodotto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProdottoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ProdottoDao(){
        emf = Persistence.createEntityManagerFactory("magazzino");
        em = emf.createEntityManager();
    }

    public void inserisciProdotto(Prodotto c){
        EntityTransaction et = em.getTransaction();
        et.begin();

        em.persist(c);
        et.commit();
    }

    public Prodotto getById(int id){
        return em.find(Prodotto.class, id);
    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();
        et.begin();

        Prodotto c = getById(id);
        em.remove(c);
        et.commit();

    }
}
