package com.capco.common;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CapTest {

    Cap cap;

    @BeforeEach
    public void setUp() throws Exception {
        cap = new Cap();
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

    @Test
    public void setLabelNull() {
        assertThrows(IllegalArgumentException.class, ()->{
            cap.setLabel(null);
        });
    }

    @Test
    public void setLabelLong() {
        assertThrows(IllegalArgumentException.class, ()->{
            cap.setLabel("123456789012345678901234567890");
        });
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
        String expect = "{\"size\":\"LARGE\",\"label\":\"My Label\"}";

        assertEquals(expect,json);
    }
}