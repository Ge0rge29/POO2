// CategorieDAO.java
package Dao;

import Model.Categorie;
import Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategorieDAO extends BaseDAO<Categorie> {
    private static CategorieDAO instance;

    private CategorieDAO() {}

    public static CategorieDAO getInstance() {
        if (instance == null) instance = new CategorieDAO();
        return instance;
    }

    @Override
    public void insert(Categorie c) {
        String sql = "INSERT INTO categorii (cod, nume, descriere) VALUES (?, ?, ?) ON CONFLICT (cod) DO NOTHING";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getCod());
            stmt.setString(2, c.getNume());
            stmt.setString(3, c.getDescriere());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Categorie> findAll() {
        List<Categorie> categorii = new ArrayList<>();
        String sql = "SELECT * FROM categorii";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categorii.add(new Categorie(
                        rs.getString("cod"),
                        rs.getString("nume"),
                        rs.getString("descriere")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categorii;
    }

    @Override
    public void update(Categorie c) {
        String sql = "UPDATE categorii SET nume=?, descriere=? WHERE cod=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNume());
            stmt.setString(2, c.getDescriere());
            stmt.setString(3, c.getCod());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String cod) {
        String sql = "DELETE FROM categorii WHERE cod=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cod);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}