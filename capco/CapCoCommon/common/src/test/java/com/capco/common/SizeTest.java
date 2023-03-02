package com.capco.commons;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

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

    @Test (expected = IllegalArgumentException.class)
    public void testFromWrongString() throws Exception {
        Size size = Size.valueOf("MEDUIM");
        assertEquals(Size.MEDIUM, size);
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