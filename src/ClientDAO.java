import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private static ClientDAO instance = null;
    private Connection connection;

    private ClientDAO() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_delivery",
                    "root",
                    "tIkitaka1."
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ClientDAO getInstance() {
        if (instance == null) {
            instance = new ClientDAO();
        }
        return instance;
    }

    public void create(Client client) {
        try {
            String sql = "INSERT INTO client (nume, email, adresa) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, client.getNume());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getAdresa());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> readAll() {
        List<Client> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client");
            while (rs.next()) {
                Client c = new Client(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("email"),
                        rs.getString("adresa")
                );
                list.add(c);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(Client client) {
        try {
            String sql = "UPDATE client SET nume = ?, email = ?, adresa = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, client.getNume());
            stmt.setString(2, client.getEmail());
            stmt.setString(3, client.getAdresa());
            stmt.setInt(4, client.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM client WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
