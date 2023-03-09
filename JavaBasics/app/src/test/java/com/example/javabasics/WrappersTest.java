package com.example.javabasics;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WrappersTest {

    @Test
    public void getFibs() {
        Wrappers wrappers = new Wrappers();
        int n = 5;
        List<Integer> fibs = wrappers.getFibs(n);
        List<Integer> expect = new ArrayList<Integer>();
        expect.add(0); expect.add(1); expect.add(1); expect.add(2); expect.add(3);
        assertArrayEquals(fibs.toArray(),expect.toArray());
    }
}