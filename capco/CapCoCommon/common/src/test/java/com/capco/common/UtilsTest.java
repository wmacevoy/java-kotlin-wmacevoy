package com.capco.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void codepoints() {
        assertEquals(0,Utils.codepoints(""));
        assertEquals(5,Utils.codepoints("Hello"));
        assertEquals(8,Utils.codepoints("Hello 👍!"));
    }
}