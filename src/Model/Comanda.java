package Model;

import java.util.HashMap;
import java.util.Map;

public class Comanda {
    private String numarComanda;
    private String data;
    private Map<Produs, Integer> produse;

    public Comanda(String numarComanda, String data) {
        this.numarComanda = numarComanda;
        this.data = data;
        this.produse = new HashMap<>();
    }

    public String getNumarComanda() {
        return numarComanda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Map<Produs, Integer> getProduse() {
        return produse;
    }

    public void adaugaProdus(Produs produs, int cantitate) {
        produse.put(produs, cantitate);
    }

    public double calculeazaValoareaTotala() {
        return produse.entrySet().stream()
                .mapToDouble(e -> e.getKey().getPret() * e.getValue())
                .sum();
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "numarComanda='" + numarComanda + '\'' +
                ", data='" + data + '\'' +
                ", produse=" + produse.size() +
                ", valoare=" + calculeazaValoareaTotala() +
                '}';
    }
}
