package com.capco.server;

import com.example.capco.Cap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    Model model = new Model();
    @GetMapping("/caps")
    List<Cap> getGaps() {
        return model.findAll();
    }
}
