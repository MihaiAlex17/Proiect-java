import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurierDAO {
    private static CurierDAO instance = null;
    private Connection connection;

    private CurierDAO() {
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

    public static CurierDAO getInstance() {
        if (instance == null) {
            instance = new CurierDAO();
        }
        return instance;
    }

    public void create(Curier curier) {
        try {
            String sql = "INSERT INTO curier (id, nume, email, vehicul) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, curier.getId());
            stmt.setString(2, curier.getNume());
            stmt.setString(3, curier.getEmail());
            stmt.setString(4, curier.getVehicul());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Curier> readAll() {
        List<Curier> list = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM curier");
            while (rs.next()) {
                Curier c = new Curier(
                        rs.getInt("id"),
                        rs.getString("nume"),
                        rs.getString("email"),
                        rs.getString("vehicul")
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

    public void update(Curier curier) {
        try {
            String sql = "UPDATE curier SET nume = ?, email = ?, vehicul = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, curier.getNume());
            stmt.setString(2, curier.getEmail());
            stmt.setString(3, curier.getVehicul());
            stmt.setInt(4, curier.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM curier WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
