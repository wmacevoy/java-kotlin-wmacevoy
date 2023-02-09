package com.example.myapplication;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

    @Test
    public void toJSON() {
        Car car = new Car("vw",1972, Kind.CAR);
        String json = car.toJSON();
        assertEquals("{\"model\":\"vw\",\"year\":1972,\"kind\":\"CAR\"}",json);
    }

    @Test
    public void fromJSON() {
        String json = "{\"model\":\"vw\",\"year\":1972,\"kind\":\"CAR\"}";
        Car car = Car.fromJSON(json);
        assertEquals("vw",car.getModel());
        assertEquals(1972, car.getYear());
    }
}