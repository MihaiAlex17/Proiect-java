import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Localuri {
    private int id;
    private String nume;
    private String tipMancare;
    private double rating;
    private String adresa;
    private List<Comanda> comenzi;
    private List<Produs> produse;
    private List<Recenzie> recenzii;

    public Localuri(int id, String nume, String tipMancare, double rating, String adresa) {
        this.id = id;
        this.nume = nume;
        this.tipMancare = tipMancare;
        this.rating = rating;
        this.adresa = adresa;
        this.comenzi = new ArrayList<>();
        this.produse = new ArrayList<>();
        this.recenzii = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getTip() {
        return tipMancare;
    }

    public String getAdresa() {
        return adresa;
    }

    public double getRating() {
        return rating;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public List<Recenzie> getRecenzii() {
        return recenzii;
    }

    public void adaugaProdus(Produs produs) {
        produse.add(produs);
    }

    public void adaugaRecenzie(Recenzie recenzie) {
        recenzii.add(recenzie);
        recenzii.sort(Comparator.comparingDouble(Recenzie::getRating).reversed());
    }

    @Override
    public String toString() {
        return "Local: " + nume + "\n" +
                "Tip: " + tipMancare + "\n" +
                "Rating: " + rating + "\n" +
                "Adresa: " + adresa + "\n" +
                "Numar produse: " + produse.size() + "\n" + "\n";
    }

}
