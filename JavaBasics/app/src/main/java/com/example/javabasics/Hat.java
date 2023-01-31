package com.example.javabasics;

public class Hat {
    boolean isOld = false; // true or false
    byte age; // -128 .. 127
    short threadCount; // -32768 .. 32767
    int priceInCents; // -2 billion .. + 2 billion
    long taxId; // -2^63 ... 2^63-1
    float size; // base 2 representation (about 7 decimal digits mantessa ) x 10^(p/m 30)
    double distToCenterOfUniverseInAngstroms; // like float 15 digits pm 300

    char x; // 0 .. 65535 (part of a UTF-16 multichar encoding in a String

    String name;
}
