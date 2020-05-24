package javabegin.demo;

import java.util.Comparator;

// сравниватель 2-х значений (нужно для сортировки таблицы по полю)
public class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        Double i1 = Double.parseDouble(o1.toString());
        Double i2 = Double.parseDouble(o2.toString());
        
        if (i1<i2) return 1;
        else if (i1>i2) return -1;
        
        return 0;
    }

    
}
