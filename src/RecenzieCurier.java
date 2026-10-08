import java.util.Date;

public class RecenzieCurier {
    private Client client;
    private Curier curier;
    private String comentariu;
    private double rating;
    private Date dataRecenzie;

    public RecenzieCurier(Client client, Curier curier, String comentariu, double rating) {
        this.client = client;
        this.curier = curier;
        this.comentariu = comentariu;
        this.rating = rating;
        this.dataRecenzie = new Date();
    }

    @Override
    public String toString() {
        return "Recenzie Curier:" +
                "\nClient: " + client.getNume() +
                "\nCurier: " + curier.getNume() +
                "\nComentariu: " + comentariu +
                "\nRating: " + rating +
                "\nData Recenzie: " + dataRecenzie;
    }
}
