package Dao;

import Model.Distribuitor;
import Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DistribuitorDAO {

    // 👇 Singleton
    private static DistribuitorDAO instance;

    private DistribuitorDAO() {}

    public static DistribuitorDAO getInstance() {
        if (instance == null) {
            instance = new DistribuitorDAO();
        }
        return instance;
    }

    public void insert(Distribuitor distribuitor) {
        String sql = "INSERT INTO distribuitori (cod, nume, adresa, telefon, email) VALUES (?, ?, ?, ?, ?) ON CONFLICT (cod) DO NOTHING";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, distribuitor.getCod());
            stmt.setString(2, distribuitor.getNume());
            stmt.setString(3, distribuitor.getAdresa());
            stmt.setString(4, distribuitor.getTelefon());
            stmt.setString(5, distribuitor.getEmail());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Distribuitor> findAll() {
        List<Distribuitor> distribuitori = new ArrayList<>();
        String sql = "SELECT * FROM distribuitori";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                distribuitori.add(new Distribuitor(
                        rs.getString("cod"),
                        rs.getString("nume"),
                        rs.getString("adresa"),
                        rs.getString("telefon"),
                        rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return distribuitori;
    }

    public void update(Distribuitor distribuitor) {
        String sql = "UPDATE distribuitori SET nume = ?, adresa = ?, telefon = ?, email = ? WHERE cod = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, distribuitor.getNume());
            stmt.setString(2, distribuitor.getAdresa());
            stmt.setString(3, distribuitor.getTelefon());
            stmt.setString(4, distribuitor.getEmail());
            stmt.setString(5, distribuitor.getCod());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String cod) {
        String sql = "DELETE FROM distribuitori WHERE cod = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cod);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
