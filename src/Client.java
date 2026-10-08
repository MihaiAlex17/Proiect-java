public class Client extends Utilizator {
    private String adresa;
    private Comanda comanda;

    public Client(int id, String nume, String email, String adresa) {
        super(id, nume, email);
        this.adresa = adresa;
        this.comanda = null;
    }

    public String getAdresa() {
        return this.adresa;
    }


    @Override
    public String toString() {
        return "Client: " + getNume() + "\n" +
                "ID: " + getId() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Adresa: " + adresa + "\n" +
                "Comanda curenta: " + (comanda != null ? comanda : "niciuna") + "\n\n";
    }

}
