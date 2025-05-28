// ProdusDAO.java
package Dao;

import Model.Produs;
import Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdusDAO extends BaseDAO<Produs> {
    private static ProdusDAO instance;

    private ProdusDAO() {}

    public static ProdusDAO getInstance() {
        if (instance == null) instance = new ProdusDAO();
        return instance;
    }

    @Override
    public void insert(Produs produs) {
        String sql = "INSERT INTO produse (cod, denumire, pret, cant_minima, cod_categorie, cod_distribuitor) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON CONFLICT (cod) DO NOTHING";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produs.getCod());
            stmt.setString(2, produs.getDenumire());
            stmt.setDouble(3, produs.getPret());
            stmt.setInt(4, produs.getCantitateMinima());
            stmt.setString(5, produs.getCategorie().getCod());
            stmt.setString(6, produs.getDistribuitor().getCod());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Produs> findAll() {
        List<Produs> produse = new ArrayList<>();
        String sql = "SELECT * FROM produse";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                produse.add(new Produs(
                        rs.getString("cod"),
                        rs.getString("denumire"),
                        rs.getDouble("pret"),
                        rs.getInt("cant_minima"),
                        null, null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produse;
    }

    @Override
    public void update(Produs produs) {
        String sql = "UPDATE produse SET denumire=?, pret=?, cant_minima=?, cod_categorie=?, cod_distribuitor=? WHERE cod=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produs.getDenumire());
            stmt.setDouble(2, produs.getPret());
            stmt.setInt(3, produs.getCantitateMinima());
            stmt.setString(4, produs.getCategorie().getCod());
            stmt.setString(5, produs.getDistribuitor().getCod());
            stmt.setString(6, produs.getCod());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String cod) {
        String sql = "DELETE FROM produse WHERE cod = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cod);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
