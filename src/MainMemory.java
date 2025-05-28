import Model.*;
import Service.InventoryServiceMemory;

public class MainMemory {
    public static void main(String[] args) {
        InventoryServiceMemory service = new InventoryServiceMemory();

        Categorie cat = new Categorie("C001", "Electronice", "Produse electronice");
        Distribuitor dist = new Distribuitor("D001", "Altex", "Str. Mare 1", "0712345678", "altex@shop.ro");

        Produs telefon = new ProdusNeperisabil("P001", "Samsung S22", 3000.0, 5, cat, dist, 24);
        Produs lapte = new ProdusPerisabil("P002", "Lapte Zuzu", 6.5, 10, cat, dist, "2025-10-01");

        service.adaugaProdusInStoc(telefon, 10, "Depozit A");
        service.adaugaProdusInStoc(lapte, 25, "Raft B");

        System.out.println("-- Produse în stoc --");
        for (Produs p : service.getToateProdusele()) {
            System.out.println(p);
        }

        System.out.println("-- Căutare după 'samsung' --");
        for (Produs p : service.cautaProduseDupaDenumire("samsung")) {
            System.out.println(p);
        }

        Comanda comanda = service.creeazaComanda("CMD001", "2025-05-28");
        comanda.adaugaProdus(telefon, 2);
        boolean succes = service.proceseazaComanda(comanda);

        System.out.println("Comandă procesată: " + succes);
        System.out.println("Stoc rămas telefon: " + service.getStoc("P001").getCantitate());
        System.out.println("Valoare totală stoc: " + service.calculeazaValoareTotalaStoc());
    }
}
