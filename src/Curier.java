import java.util.ArrayList;
import java.util.List;

public class Curier extends Utilizator {
    private String vehicul;
    private List<Comanda> comenziLivrate;
    private List<RecenzieCurier> recenzii;

    public Curier(int id, String nume, String email, String vehicul) {
        super(id, nume, email);
        this.vehicul = vehicul;
        this.comenziLivrate = new ArrayList<>();
        this.recenzii = new ArrayList<>();
    }

    public String getVehicul() {
        return vehicul;
    }

    public List<RecenzieCurier> getRecenzii() {
        return recenzii;
    }

    public void adaugaRecenzie(RecenzieCurier recenzie) {
        recenzii.add(recenzie);
    }

    public void adaugaComandaLivrata(Comanda comanda) {
        comenziLivrate.add(comanda);
    }

    @Override
    public String toString() {
        return "Curier: " + getNume() + "\n" +
                "ID: " + getId() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Vehicul: " + vehicul + "\n" +
                "Numar de recenzii: " + recenzii.size() + "\n\n";
    }

}
