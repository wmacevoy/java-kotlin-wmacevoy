package com.example.javabasics;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BuildersTest {

    final int n = 100;
    Builders builders;
    @Before
    public void before() {
        builders = new Builders();
    }


    @Test
    public void stars1() {
        String ans = builders.stars1(n);
    }

    @Test
    public void stars2() {
        String ans = builders.stars2(n);
    }

    @Test
    public void stars3() {
        String ans = builders.stars3(n);
    }
}