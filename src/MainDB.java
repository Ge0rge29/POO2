import Model.*;
import Dao.*;
import Service.AuditService;

public class MainDB {
    public static void main(String[] args) {
        AuditService audit = AuditService.getInstance();

        Categorie cat = new Categorie("C001", "Electronice", "Produse electronice");
        CategorieDAO.getInstance().insert(cat);
        audit.log("insert_categorie");

        Distribuitor dist = new Distribuitor("D001", "Altex", "Str. Mare 1", "0712345678", "altex@shop.ro");
        DistribuitorDAO.getInstance().insert(dist);
        audit.log("insert_distribuitor");

        Produs telefon = new ProdusNeperisabil("P001", "Samsung S22", 3000.0, 5, cat, dist, 24);
        Produs lapte = new ProdusPerisabil("P002", "Lapte Zuzu", 6.5, 10, cat, dist, "2025-10-01");

        ProdusDAO.getInstance().insert(telefon);
        audit.log("insert_produs_telefon");

        ProdusDAO.getInstance().insert(lapte);
        audit.log("insert_produs_lapte");

        Comanda comanda = new Comanda("CMD001", "2025-05-28");
        comanda.adaugaProdus(telefon, 2);
        comanda.adaugaProdus(lapte, 5);
        ComandaDAO.getInstance().insert(comanda);
        audit.log("insert_comanda");

        System.out.println("✔️ Categoria, distribuitorul, produsele și comanda au fost trimise către baza de date.");
    }
}
