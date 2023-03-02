package com.capco.common;

public class Utils {
    public static int codepoints(String string) {
        return string.codePointCount(0, string.length());
    }
}
