package com.example.javabasics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Wrappers {
    int i = 3;
    Integer wi = Integer.valueOf(3);

    long el = 3L;
    Long wel = Long.valueOf(3L);

    int sum(int x, int y) {
        return x+y;
    }

    void useSum(){
        wi = sum(wi,i);
        wi = Integer.valueOf(sum(wi.intValue(),i));
    }

    int addUpList1(List<Integer> a) {
        int sum = 0;
        for (Integer x : a) {
            sum += x;
        }
        return sum;
    }

    int addUpList2(List<Integer> a) {
        int sum = 0;
        Iterator<Integer> i = a.iterator();
        while (i.hasNext()) {
            Integer x = i.next();
            sum += x;
        }
        return sum;
    }

    void printList3(List<Integer> a) {
        a.forEach((x) -> { System.out.println(x); });
    }

    void countBig(List<Integer> a, int cutoff) {
        long expnsive = a.stream().filter((x) -> (x >= cutoff)).count();
    }

    void arrays() {
        int [] a = new int [] { 3, 5 , 7 };
        ArrayList < Integer > b = new ArrayList < Integer >(a.length);
        for (int i=0; i<a.length; ++i) {
            b.add(a[i]);
        }
    }
    List<Integer> getFibsBad(int n) {
        List<Integer> fibs = new ArrayList<Integer>();

        Iterator<Integer> m1 = null;
        Iterator<Integer> m2 = null;
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                fibs.add(0);
                m1 = fibs.iterator();
            } else if (i == 1) {
                fibs.add(1);
                m2 = fibs.iterator();
            } else {
                // concurrent modification exception
                fibs.add(m1.next() + m2.next());
            }
        }
        return fibs;
    }

    List<Integer> getFibs(int n) {
        List<Integer> fibs = new ArrayList<Integer>(n);

        int v1 = 1;
        int v2 = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0) {
                fibs.add(0);
            } else if (i == 1) {
                fibs.add(1);
            } else {
                int sum = v1+v2;
                fibs.add(sum);
                v2=v1;
                v1=sum;
            }
        }
        return fibs;
    }
}
