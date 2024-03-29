package com.capco.server;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ControllerTest {
    @Autowired
    Controller controller;
    @Autowired
    Model model;

    @Test
    void autowiring() {
        assertNotNull(controller);
        assertNotNull(model);
    }
}