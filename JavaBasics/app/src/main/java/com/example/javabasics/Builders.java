package com.example.javabasics;

import android.app.ServiceStartNotAllowedException;

public class Builders {
    public String stars1(int n) {
        String ans = "";
        for (int i=0; i<n; ++i) {
            ans = ans + "*";
        }
        return ans;
    }
    public String stars2(int n) {
        StringBuffer ans = new StringBuffer();
        for (int i=0; i<n; ++i) {
            ans.append("*");
        }
        return ans.toString();
    }

    public String stars3(int n) {
        StringBuilder ans = new StringBuilder(n);
        for (int i=0; i<n; ++i) {
            ans.append("*");
        }
        return ans.toString();
    }

}
