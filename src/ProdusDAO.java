import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusDAO {
    private static ProdusDAO instance = null;
    private Connection connection;

    private ProdusDAO() {
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

    public static ProdusDAO getInstance() {
        if (instance == null) {
            instance = new ProdusDAO();
        }
        return instance;
    }

    public void create(Produs produs, int idLocal) {
        try {
            String sql = "INSERT INTO produs (nume, pret, categorie, gramaj, id_local) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produs.getNume());
            stmt.setDouble(2, produs.getPret());
            stmt.setString(3, produs.getCategorie());
            stmt.setInt(4, produs.getGramaj());
            stmt.setInt(5, idLocal);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Produs> readAll() {
        List<Produs> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produs");
            while (rs.next()) {
                Produs p = new Produs(
                        rs.getString("nume"),
                        rs.getDouble("pret"),
                        rs.getString("categorie"),
                        rs.getInt("gramaj")
                );
                list.add(p);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(int id, Produs produs) {
        try {
            String sql = "UPDATE produs SET nume = ?, pret = ?, categorie = ?, gramaj = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produs.getNume());
            stmt.setDouble(2, produs.getPret());
            stmt.setString(3, produs.getCategorie());
            stmt.setInt(4, produs.getGramaj());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM produs WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
