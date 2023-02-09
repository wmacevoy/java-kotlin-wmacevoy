package com.example.myapplication;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

import java.io.IOException;

@JsonDeserialize(using = Car.Deserializer.class)
public class Car {
    public static class Deserializer extends StdDeserializer<Car> {
        public Deserializer() {
            this(null);
        }

        public Deserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Car deserialize(JsonParser jp, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            JsonNode node = jp.getCodec().readTree(jp);
            String model = node.get("model").asText();
            int year = (Integer) ((IntNode) node.get("year")).numberValue();
            Kind kind = Kind.valueOf(node.get("kind").asText());
            return new Car(model,year,kind);
        }
    }

    private static ObjectMapper objectMapper = null;
    protected static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        return objectMapper;
    }

    public String toJSON() {
        try {
            return getObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car fromJSON(String json) {
        try {
            return getObjectMapper().readValue(json, Car.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private String model;
    private int year;

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    private Kind kind;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Car(String model, int year, Kind kind) {
        this.model = model;
        this.year = year;
        this.kind = kind;
    }
}
