package com.capco.server;

import com.capco.common.Cap;
import com.capco.common.Size;

import java.util.LinkedList;
import java.util.List;

public class Model {
    List<Cap> caps;
    Model() {
        caps = new LinkedList<Cap>();
        caps.add(new Cap("Go CMU", Size.LARGE));
        caps.add(new Cap("Jackalopes!", Size.MEDIUM));
    }

    List<Cap> findAll() {
        return caps;
    }
}
