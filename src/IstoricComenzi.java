import java.util.ArrayList;
import java.util.List;

public class IstoricComenzi {
    private Client client;
    private List<Comanda> comenzi;

    public IstoricComenzi(Client client) {
        this.client = client;
        this.comenzi = new ArrayList<>();
    }

    public void adaugaComanda(Comanda comanda) {
        comenzi.add(comanda);
    }

    public void afiseazaIstoric() {
        System.out.println("Istoric comenzi pentru clientul: " + client.getNume());
        for (Comanda c : comenzi) {
            System.out.println(c);
        }
    }

}
