package com.example.javabasics;

public class Hat implements AutoCloseable {
    private boolean isOld = false; // true or false

    private byte age; // -128 .. 127
    private short threadCount; // -32768 .. 32767
    private int priceInCents; // -2 billion .. + 2 billion
    private long taxId; // -2^63 ... 2^63-1

    private float size; // base 2 representation (about 7 decimal digits mantessa ) x 10^(p/m 30)
    private double distToCenterOfUniverseInAngstroms; // like float 15 digits pm 300

    private char x; // 0 .. 65535 (part of a UTF-16 multichar encoding in a String

    private String name;

    Hat(float size, String name) {
        this.size = size;
        this.name = name;
    }
    Hat(float size) {
        this(size,"hat");
    }
    Hat() {
        this(10.0f, "hat");
    }

    public void close() {
        System.out.println("closing hat " + this + " named " + name);
    }

    public boolean isOld() {
        return isOld;
    }

    public void setOld(boolean old) {
        isOld = old;
    }

    public short getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(short threadCount) {
        if (threadCount < 0) {
            this.threadCount = threadCount;
        } else {
            throw new IllegalArgumentException("thread count must be positive");
        }
    }

    public int getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(int priceInCents) {
        this.priceInCents = priceInCents;
    }

    public long getTaxId() {
        return taxId;
    }

    public void setTaxId(long taxId) {
        this.taxId = taxId;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public double getDistToCenterOfUniverseInAngstroms() {
        return distToCenterOfUniverseInAngstroms;
    }

    public void setDistToCenterOfUniverseInAngstroms(double distToCenterOfUniverseInAngstroms) {
        this.distToCenterOfUniverseInAngstroms = distToCenterOfUniverseInAngstroms;
    }

    public char getX() {
        return x;
    }

    public void setX(char x) {
        this.x = x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
