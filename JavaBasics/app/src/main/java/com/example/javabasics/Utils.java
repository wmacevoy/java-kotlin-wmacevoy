package com.example.javabasics;

public class Utils {
    public static int codepoints(String string) {
        return string.codePointCount(0, string.length());
    }
}
