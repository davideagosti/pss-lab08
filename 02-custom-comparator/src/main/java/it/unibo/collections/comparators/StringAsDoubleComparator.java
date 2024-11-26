package it.unibo.collections.comparators;

import java.util.Comparator;

public class StringAsDoubleComparator implements Comparator<String> {
    
    @Override
    public  int compare(String s1, String s2) {
        // Converte le stringhe in double e le confronta
        Double d1 = Double.parseDouble(s1);
        Double d2 = Double.parseDouble(s2);
        return d1.compareTo(d2);
    }

}
