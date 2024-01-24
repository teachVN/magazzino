package it.epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

//entità in relazione many to many con Prodotto e many to one con Cliente
@Entity
@Table(name = "ordini")
public class Ordine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "data_ordine")
    private LocalDate dataOrdine;

    @Column(name = "data_evasione")
    private LocalDate dataEvasione;

    @ManyToOne
    @JoinColumn(name = "cliente_fk")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(name = "prodotti_ordini",
            joinColumns = @JoinColumn(name = "ordini_fk"),
            inverseJoinColumns = @JoinColumn(name = "prodotti_fk"))
    private List<Prodotto> prodotti;

    public Ordine(){

    }

    public Ordine(int id, LocalDate dataOrdine, LocalDate dataEvasione, Cliente cliente) {
        this.id = id;
        this.dataOrdine = dataOrdine;
        this.dataEvasione = dataEvasione;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(LocalDate dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public LocalDate getDataEvasione() {
        return dataEvasione;
    }

    public void setDataEvasione(LocalDate dataEvasione) {
        this.dataEvasione = dataEvasione;
    }

    public Cliente getCliente() {
        return cliente;
    }



    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(List<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", dataOrdine=" + dataOrdine +
                ", dataEvasione=" + dataEvasione +
                ", prodotti=" + prodotti +
                '}';
    }
}
