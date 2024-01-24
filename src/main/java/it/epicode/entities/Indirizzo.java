package it.epicode.entities;

import jakarta.persistence.*;

//relazione one to one  con Cliente
@Entity
@Table(name = "indirizzi")
public class Indirizzo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String via;
    private String civico;

    private String citta;

    //relazione one to one sia unidirezionale che bidirezionale con Cliente
    @OneToOne
    @JoinColumn(name = "cliente_fk")
    private Cliente cliente;

    public Indirizzo(){

    }

    public Indirizzo(String via, String civico, String citta) {
        this.via = via;
        this.civico = civico;
        this.citta = citta;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Indirizzo{" +
                "via='" + via + '\'' +
                ", civico='" + civico + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
