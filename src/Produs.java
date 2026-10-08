public class Produs {
    private String nume;
    private double pret;
    private String categorie;
    private int gramaj;

    public Produs(String nume, double pret, String categorie, int gramaj) {
        this.nume = nume;
        this.pret = pret;
        this.categorie = categorie;
        this.gramaj = gramaj;

    }

    public String getNume() {
        return nume;
    }

    public double getPret() {
        return pret;
    }

    public String getCategorie() {
        return categorie;
    }

    public int getGramaj() {
        return gramaj;
    }

    @Override
    public String toString() {
        return "Produs: " + nume + "\n" +
                "Pret: " + pret + " RON\n" +
                "Categorie: " + categorie + "\n" +
                "Gramaj: " + gramaj + "g\n\n";
    }

}
