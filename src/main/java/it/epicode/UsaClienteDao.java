package it.epicode;

import it.epicode.dao.ClienteDao;
import it.epicode.dao.IndirizzoDao;
import it.epicode.dao.OrdineDao;
import it.epicode.dao.ProdottoDao;
import it.epicode.entities.Cliente;
import it.epicode.entities.Indirizzo;
import it.epicode.entities.Ordine;
import it.epicode.entities.Prodotto;

import java.time.LocalDate;
import java.util.List;

public class UsaClienteDao {

    public static void main(String[] args) {
        //creare un dao per ogni entità
        ClienteDao clienteDao = new ClienteDao();
        IndirizzoDao indirizzoDao = new IndirizzoDao();
        OrdineDao ordineDao = new OrdineDao();
        ProdottoDao prodottoDao = new ProdottoDao();

        Cliente c = new Cliente();

        //c.setIndirizzo(i);

        clienteDao.inserisciCliente(c);

        Indirizzo i = new Indirizzo();
        i.setCliente(c);
        i.setCitta("Salerno");

        indirizzoDao.inserisciIndirizzo(i);

        Cliente c2 = clienteDao.getById(1);

        Ordine o1 = new Ordine();
        o1.setDataOrdine(LocalDate.of(2023,5,5));
        o1.setCliente(c2);

        ordineDao.inserisciOrdine(o1);

        c2.getOrdini().stream().forEach(ordine -> System.out.println(ordine));

        System.out.println(c2);

        Prodotto p1 = new Prodotto();
        p1.setNome("penna");

        Prodotto p2 = new Prodotto();
        p2.setNome("matita");

        prodottoDao.inserisciProdotto(p1);
        prodottoDao.inserisciProdotto(p2);

        Ordine o2 = ordineDao.getById(1);

        o2.setProdotti(List.of(p1,p2));

        ordineDao.inserisciOrdine(o2);

        //clienteDao.delete(1);


    }
}
