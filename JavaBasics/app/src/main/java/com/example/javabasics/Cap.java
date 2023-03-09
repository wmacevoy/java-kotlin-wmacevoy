package com.example.javabasics;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Cap implements Comparable<Cap> {
    private int threadCount;

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    void doUselessThingsWithThreadCount() {
        threadCount++;

        // std::list < int > ints;
        List< Integer > ints = new LinkedList< Integer >();

        // for (std::list<int>::iterator i = ints.begin();  i!=ints.end(); ++i) {
        //     cout << *i;
        // }
        // for (auto &x : ints) { ... }
        // i = begin() - 1;
        Iterator<Integer> i = ints.iterator();
        while (i.hasNext()) { // (i+1) != end())
            // ++i; x = *i;
            Integer x = i.next();
        }

        for (Integer x : ints) {

        }
    }
    public static final Size DEFAULT_SIZE = Size.MEDIUM;

    private static Size size = DEFAULT_SIZE;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        if (size == null) {
            throw new IllegalArgumentException("size cannot be null");
        }
        this.size = size;
    }

    private String label = "";

    public String getLabel() {
        return label;
    }

    public void shout(int loudness) {
        // StringBuffer - thread safe / slower version
        // StringBuilder - not thread safe / faster
        StringBuilder sb = new StringBuilder(label.length() + loudness);
        sb.append(label);
        for (int i = 0; i<loudness; ++i) {
            sb.append("!");
        }
        label = sb.toString();
    }

    public void setLabel(String label) {
        if (label == null) {
            throw new IllegalArgumentException("label cannot be null");
        }
        if (Utils.codepoints(label) > 20) {
            throw new IllegalArgumentException("label is too long");
        }
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Cap ? compareTo((Cap) o) == 0 : false;
//        if (this == o) return true;
//        if (!(o instanceof Cap)) return false;
//        Cap cap = (Cap) o;
//        return threadCount == cap.threadCount && getSize().equals(cap.getSize()) && getLabel().equals(cap.getLabel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(threadCount, getSize(), getLabel());
    }

    @Override
    public int compareTo(Cap cap) {
        if (threadCount != cap.threadCount) return Integer.compare(threadCount,cap.threadCount);
        if (getSize() != cap.getSize()) return getSize().compareTo(cap.getSize());
        return getLabel().compareTo(cap.getLabel());
    }
}
