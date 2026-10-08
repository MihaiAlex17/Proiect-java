import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int idComanda;
    private Client client;
    private Localuri local;
    private List<Produs> produse;
    private Curier curier;


    public Comanda(int idComanda, Client client, Localuri local) {
        this.idComanda = idComanda;
        this.client = client;
        this.local = local;
        this.produse = new ArrayList<>();

    }

    public void adaugaProdus(Produs produs) {
        produse.add(produs);
    }


    public int getIdComanda() {
        return idComanda;
    }

    public Client getClient() {
        return client;
    }

    public Localuri getLocal() {
        return local;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public Curier getCurier() {
        return curier;
    }


    public void setCurier(Curier curier) {
        this.curier = curier;
    }
    @Override
    public String toString() {
        return "Comanda ID: " + idComanda + "\n" +
                "Client: " + client.getNume() + "\n" +
                "Local: " + local.getNume() + "\n" +
                "Curier: " + curier.getNume() + "\n" +
                "Produse: " + produse + "\n" ;

    }

}
