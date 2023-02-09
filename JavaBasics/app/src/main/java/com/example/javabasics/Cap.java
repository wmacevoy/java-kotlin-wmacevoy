package com.example.javabasics;

public class Cap {
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

    public void setLabel(String label) {
        if (label == null) {
            throw new IllegalArgumentException("label cannot be null");
        }
        if (Utils.codepoints(label) > 20) {
            throw new IllegalArgumentException("label is too long");
        }
        this.label = label;
    }
}
