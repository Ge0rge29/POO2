import Model.*;
import Dao.*;

public class MainDB {
    public static void main(String[] args) {
        Categorie cat = new Categorie("C001", "Electronice", "Produse electronice");
        CategorieDAO.getInstance().insert(cat);

        Distribuitor dist = new Distribuitor("D001", "Altex", "Str. Mare 1", "0712345678", "altex@shop.ro");
        DistribuitorDAO.getInstance().insert(dist);

        Produs telefon = new ProdusNeperisabil("P001", "Samsung S22", 3000.0, 5, cat, dist, 24);
        Produs lapte = new ProdusPerisabil("P002", "Lapte Zuzu", 6.5, 10, cat, dist, "2025-10-01");

        ProdusDAO.getInstance().insert(telefon);
        ProdusDAO.getInstance().insert(lapte);

        Comanda comanda = new Comanda("CMD001", "2025-05-28");
        comanda.adaugaProdus(telefon, 2);
        comanda.adaugaProdus(lapte, 5);
        ComandaDAO.getInstance().insert(comanda);

        System.out.println("✔️ Categoria, distribuitorul, produsele și comanda au fost trimise către baza de date.");
    }
}
