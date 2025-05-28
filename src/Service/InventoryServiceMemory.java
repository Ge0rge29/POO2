package Service;

import Model.*;

import java.util.*;

public class InventoryServiceMemory {
    private List<Produs> produse = new ArrayList<>();
    private List<Categorie> categorii = new ArrayList<>();
    private List<Distribuitor> distribuitori = new ArrayList<>();
    private Map<String, Stoc> stocuri = new HashMap<>();
    private List<Comanda> comenzi = new ArrayList<>();
    private Set<Raport> rapoarte = new HashSet<>();

    public void adaugaCategorie(Categorie categorie) {
        categorii.add(categorie);
    }

    public void adaugaDistribuitor(Distribuitor distribuitor) {
        distribuitori.add(distribuitor);
    }

    public void adaugaProdus(Produs produs) {
        produse.add(produs);
    }

    public void adaugaProdusInStoc(Produs produs, int cantitate, String locatie) {
        adaugaProdus(produs);
        Stoc stoc = new Stoc(produs, cantitate, locatie);
        stocuri.put(produs.getCod(), stoc);
    }

    public List<Produs> getToateProdusele() {
        return new ArrayList<>(produse);
    }

    public List<Produs> getProduseOrdonateDupaPret() {
        List<Produs> sorted = new ArrayList<>(produse);
        sorted.sort(new ProdusPretComparator());
        return sorted;
    }

    public List<Stoc> getStocuriOrdonateDupaCantitate() {
        List<Stoc> sorted = new ArrayList<>(stocuri.values());
        sorted.sort(new StocCantitateComparator());
        return sorted;
    }

    public Stoc getStoc(String codProdus) {
        return stocuri.get(codProdus);
    }

    public List<Produs> cautaProduseDupaDenumire(String denumire) {
        List<Produs> rezultate = new ArrayList<>();
        for (Produs p : produse) {
            if (p.getDenumire().toLowerCase().contains(denumire.toLowerCase())) {
                rezultate.add(p);
            }
        }
        return rezultate;
    }

    public Comanda creeazaComanda(String id, String data) {
        Comanda c = new Comanda(id, data);
        comenzi.add(c);
        return c;
    }

    public boolean proceseazaComanda(Comanda comanda) {
        for (Map.Entry<Produs, Integer> entry : comanda.getProduse().entrySet()) {
            Stoc s = stocuri.get(entry.getKey().getCod());
            if (s == null || s.getCantitate() < entry.getValue()) {
                return false;
            }
        }

        for (Map.Entry<Produs, Integer> entry : comanda.getProduse().entrySet()) {
            stocuri.get(entry.getKey().getCod()).scadeCantitate(entry.getValue());
        }

        return true;
    }

    public double calculeazaValoareTotalaStoc() {
        double total = 0;
        for (Stoc s : stocuri.values()) {
            total += s.getProdus().getPret() * s.getCantitate();
        }
        return total;
    }
}
