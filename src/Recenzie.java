import java.util.Date;

public class Recenzie {
    private Client client;
    private Localuri local;
    private String comentariu;
    private double rating;
    private Date dataRecenzie;

    public Recenzie(Client client, Localuri local, String comentariu, double rating) {
        this.client = client;
        this.local = local;
        this.comentariu = comentariu;
        this.rating = rating;
        this.dataRecenzie = new Date();
    }

    public Client getClient() {
        return client;
    }

    public Localuri getLocal() {
        return local;
    }

    public String getComentariu() {
        return comentariu;
    }

    public double getRating() {
        return rating;
    }

    public Date getDataRecenzie() {
        return dataRecenzie;
    }

    @Override
    public String toString() {
        return "Recenzie pentru localul: " + local.getNume() + "\n" +
                "Client: " + client.getNume() + "\n" +
                "Comentariu: " + comentariu + "\n" +
                "Rating: " + rating + "\n" +
                "Data: " + dataRecenzie + "\n\n";
    }

}
