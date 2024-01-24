package it.epicode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

//relazione one to one con Indirizzo e one to Many con Ordine
@Entity
@Table(name = "clienti")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "table_clienti")
    //@TableGenerator(name = "table_clienti", initialValue = 20, allocationSize = 10)
    //@SequenceGenerator(name = "sequenza_clienti", initialValue = 10, allocationSize = 10)
    private int id;

    private String nome;
    private String cognome;

    @Column(name = "data_inserimento")
    private LocalDate dataInserimento;
    //private String indirizzo;


//One to one bidirezionale(significa che la relazione è mappata attraverso il campo cliente dell'altra classe)
    @OneToOne(mappedBy = "cliente",cascade = CascadeType.REMOVE)//il cascade lo usiamo per cancellare a cascata anche tutte le relazioni che ci sono con il cliente
    private Indirizzo indirizzo;

    @OneToMany(mappedBy = "cliente")
    private List<Ordine> ordini;

    public Cliente(){

    }

    public Cliente(int id, String nome, String cognome, LocalDate dataInserimento, Indirizzo indirizzo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataInserimento = dataInserimento;
        this.indirizzo = indirizzo; //da commentare in caso di unidirezionale
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataInserimento() {
        return dataInserimento;
    }

    public void setDataInserimento(LocalDate dataInserimento) {
        this.dataInserimento = dataInserimento;
    }

    public Indirizzo getIndirizzo() { //da commentare in caso di unidirezionale
        return indirizzo;
    }

    public void setIndirizzo(Indirizzo indirizzo) { //da commentare in caso di unidirezionale
        this.indirizzo = indirizzo;
    }

    public List<Ordine> getOrdini() {
        return ordini;
    }

    public void setOrdini(List<Ordine> ordini) {
        this.ordini = ordini;
    }

    @Override
    public String toString() {
        return "Clienti{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", dataInserimento=" + dataInserimento +
                ", indirizzo='" + indirizzo + '\'' + //da commentare in caso di unidirezionale
                '}';
    }
}
