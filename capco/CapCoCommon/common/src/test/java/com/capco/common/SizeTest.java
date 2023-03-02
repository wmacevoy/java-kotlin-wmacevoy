package com.capco.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SizeTest {
    @Test
    public void testToString() {
        Size size = Size.MEDIUM;
        assertEquals("MEDIUM", size.toString());
    }

    @Test
    public void testFromString() throws Exception {
        Size size = Size.valueOf("MEDIUM");
        assertEquals(Size.MEDIUM, size);
    }

    @Test
    public void testFromWrongString() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            Size size = Size.valueOf("MEDUIM");
        });
    }

    @Test
    public void testToJson() throws Exception {
        Size size = Size.MEDIUM;
        ObjectMapper mapper = new ObjectMapper();
        String result  = mapper.writeValueAsString(size);
        String expect = "\"MEDIUM\"";
        assertEquals(expect, result);
    }

    @Test
    public void testFromJson() throws Exception {
        String json = "\"MEDIUM\"";
        Size expect = Size.MEDIUM;
        ObjectMapper mapper = new ObjectMapper();
        Size result = mapper.readValue(json,Size.class);
        assertEquals(expect, result);
    }
}