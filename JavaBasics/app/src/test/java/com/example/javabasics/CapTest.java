package com.example.javabasics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CapTest {

    Cap cap;

    List<Cap> caps;

    @Before
    public void before() {
        cap = new Cap(100, Size.MEDIUM, "hi");

        caps = new ArrayList<Cap>();
        caps.add(new Cap(Integer.MIN_VALUE,Size.SMALL,""));
        caps.add(new Cap(Integer.MIN_VALUE,Size.MEDIUM,""));
        caps.add(new Cap(Integer.MIN_VALUE,Size.LARGE,""));
        caps.add(new Cap(Integer.MIN_VALUE,Size.LARGE,"x"));
        caps.add(new Cap(0,Size.SMALL,""));
        caps.add(new Cap(Integer.MAX_VALUE,Size.SMALL,""));
    }

    @Test
    public void getSize() {
        assertEquals(Size.MEDIUM, cap.getSize());
    }

    @Test
    public void setSize() {
        cap.setSize(Size.SMALL);
        assertEquals(Size.SMALL, cap.getSize());
    }

    @Test
    public void getLabel() {
        assertEquals("hi", cap.getLabel());
    }

    @Test
    public void setLabel() {
        cap.setLabel("x");
        assertEquals("x", cap.getLabel());
    }

    //
    //  Use .equals() for objects, because == only means "alias"
    // Needed for hashes (HashMap and HashSet)
    // Must be consistent with compareTo()
    //
    @Test
    public void testEquals() {
        Cap other = new Cap(100, Size.MEDIUM, "hi");
        assertEquals(cap,other);
    }

    // Needed for HashSet or HashMap (the Key).
    //  cap.hashCode() = 22;
    //   22 % 3 = 1
    //   [ 0] -> {all caps with cap.hashCode() % 3 == 0}
    //   [ 1] -> {x}
    //   [ 2] -> {}
    //
    // Amortized O(1) for a good hash.
    @Test
    public void testHashCode() {
        long hc1 = cap.hashCode();
        Cap other = new Cap(100, Size.MEDIUM, "hi");
        Set<Integer> hashes = new TreeSet<Integer>();
        for (int t = 0 ; t < 10_000; ++t) {
            other.setThreadCount(45+23*t);
            hashes.add(other.hashCode());
        }
        // by birthday paradox, expect no collisions until about sqrt(2^32) = 2^16 hashes,
        // so 3 is a pretty big number
        assertTrue(hashes.size() >= 10_000 - 3);
    }

    // compareTo is how to compare objects
    //
    //   "cat" <= "dog" => "cat".compareTo("dog) <= 0
    //
    //  Useful (todo next) for sorting.
    //
    //  Needed for TreeMap and HashMap
    //
    //      x
    //     / \
    //    y   z
    //   /
    //  a
    // add/remove/find -> O(Log N) steps.
    //
    // must be consistent with equals
    //
    // 2 < 3 and 3 < 7 => 2 < 7  must have the transitive property.
    @Test
    public void compareTo() {
        for (int i = 0; i<caps.size(); ++i) {
            for (int j=0; j<caps.size(); ++j) {
                if (i < j) {
                    assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) < 0);
                } else if (i == j) {
                    assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) == 0);
                } else {
                    assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) > 0);
                }
            }
        }
    }

    @Test
    public void compareToBad1() {
        int i=0;
        int j=1;
        if (i < j) {
            assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) < 0);
        } else if (i == j) {
            assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) == 0);
        } else {
            assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) > 0);
        }
    }

    @Test
    public void compareToBad2() {
        int i=0;
        int j=3;
        if (i < j) {
            assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) < 0);
        } else if (i == j) {
            assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) == 0);
        } else {
            assertTrue("i="+i + " j=" + j,caps.get(i).compareTo(caps.get(j)) > 0);
        }
    }

}