// model/StocCantitateComparator.java
package Model;

import java.util.Comparator;

public class StocCantitateComparator implements Comparator<Stoc> {
    @Override
    public int compare(Stoc s1, Stoc s2) {
        return Integer.compare(s1.getCantitate(), s2.getCantitate());
    }
}