package com.example.capco;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CapTest {

    Cap cap;

    @Before
    public void setUp() throws Exception {
        cap = new Cap();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDefaultSize() {
        assertEquals(Cap.DEFAULT_SIZE,cap.getSize());
    }

    @Test
    public void setSize() {
        cap.setSize(Size.LARGE);
        assertEquals(Size.LARGE,cap.getSize());
    }

    @Test
    public void getLabel() {
        assertEquals("",cap.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLabelNull() {
        cap.setLabel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setLabelLong() {
        cap.setLabel("123456789012345678901234567890");
    }

    @Test
    public void setLabelOk() {
        cap.setLabel("Ok");
        assertEquals("Ok",cap.getLabel());
    }

    @Test
    public void fromJSON() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\n" +
                "    \"size\": \"LARGE\",\n" +
                "    \"label\": \"My Label\"\n" +
                "}";
        cap = mapper.readValue(json,Cap.class);

        assertEquals(Size.LARGE,cap.getSize());
        assertEquals("My Label",cap.getLabel());
    }

    @Test
    public void toJSON() throws Exception {
        cap = new Cap("My Label", Size.LARGE);

        ObjectMapper mapper = new ObjectMapper();
        String json  = mapper.writeValueAsString(cap);
        String expect = "{\"label\":\"My Label\",\"size\":\"LARGE\"}";

        assertEquals(expect,json);
    }
}