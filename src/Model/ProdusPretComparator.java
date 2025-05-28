// model/ProdusPretComparator.java
package Model;

import java.util.Comparator;

public class ProdusPretComparator implements Comparator<Produs> {
    @Override
    public int compare(Produs p1, Produs p2) {
        return Double.compare(p1.getPret(), p2.getPret());
    }
}