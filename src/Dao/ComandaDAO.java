package Dao;

import Model.Comanda;
import Model.Produs;
import Util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ComandaDAO {
    private static ComandaDAO instance;

    private ComandaDAO() {}

    public static ComandaDAO getInstance() {
        if (instance == null) instance = new ComandaDAO();
        return instance;
    }

    public void insert(Comanda comanda) {
        String sqlComanda = "INSERT INTO comenzi (cod, data) VALUES (?, ?) ON CONFLICT (cod) DO NOTHING";
        String sqlProduse = "INSERT INTO comenzi_produse (cod_comanda, cod_produs, cantitate) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmtCom = conn.prepareStatement(sqlComanda);
             PreparedStatement stmtProd = conn.prepareStatement(sqlProduse)) {

            conn.setAutoCommit(false);

            // ✅ Inserare comanda
            stmtCom.setString(1, comanda.getNumarComanda());
            stmtCom.setDate(2, java.sql.Date.valueOf(comanda.getData()));  // convertim String → Date
            stmtCom.executeUpdate();

            // ✅ Inserare produse
            for (Map.Entry<Produs, Integer> entry : comanda.getProduse().entrySet()) {
                stmtProd.setString(1, comanda.getNumarComanda());
                stmtProd.setString(2, entry.getKey().getCod());
                stmtProd.setInt(3, entry.getValue());
                stmtProd.addBatch();
            }

            stmtProd.executeBatch();
            conn.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comanda> findAll() {
        List<Comanda> comenzi = new ArrayList<>();
        String sql = "SELECT * FROM comenzi";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                comenzi.add(new Comanda(
                        rs.getString("cod"),
                        rs.getDate("data").toString()
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comenzi;
    }

    public void delete(String cod) {
        String sql1 = "DELETE FROM comenzi_produse WHERE cod_comanda = ?";
        String sql2 = "DELETE FROM comenzi WHERE cod = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt1 = conn.prepareStatement(sql1);
             PreparedStatement stmt2 = conn.prepareStatement(sql2)) {

            stmt1.setString(1, cod);
            stmt1.executeUpdate();

            stmt2.setString(1, cod);
            stmt2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
