package it.epicode.entities;

import jakarta.persistence.*;

import java.util.List;

//entità in relazione many to many con Ordini
@Entity
@Table(name = "prodotti")
public class Prodotto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String categoria;
    private double prezzo;

    @ManyToMany(mappedBy = "prodotti")
    private List<Ordine> ordini;

    public  Prodotto(){


    }

    public Prodotto(int id, String nome, String categoria, double prezzo, List<Ordine> ordini) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzo = prezzo;
        this.ordini = ordini;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", prezzo=" + prezzo +
                '}';
    }
}
