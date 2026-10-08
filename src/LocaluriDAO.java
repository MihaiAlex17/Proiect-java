import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocaluriDAO {
    private static LocaluriDAO instance = null;
    private Connection connection;

    private LocaluriDAO() {
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

    public static LocaluriDAO getInstance() {
        if (instance == null) {
            instance = new LocaluriDAO();
        }
        return instance;
    }

    public void create(Localuri local) {
        try {
            String sql = "INSERT INTO localuri (nume, tip, rating, adresa) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, local.getNume());
            stmt.setString(2, local.getTip());
            stmt.setDouble(3, local.getRating());
            stmt.setString(4, local.getAdresa());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Localuri> readAll() {
        List<Localuri> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM localuri");
            while (rs.next()) {
                Localuri l = new Localuri(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("tip"),
                        rs.getDouble("rating"),
                        rs.getString("adresa")
                );
                list.add(l);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(Localuri local) {
        try {
            String sql = "UPDATE localuri SET nume = ?, tip = ?, rating = ?, adresa = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, local.getNume());
            stmt.setString(2, local.getTip());
            stmt.setDouble(3, local.getRating());
            stmt.setString(4, local.getAdresa());
            stmt.setInt(5, local.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM localuri WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
