package com.smartflow.controller;

import com.smartflow.model.TrafficData;
import com.smartflow.service.TrafficService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/traffic")
@CrossOrigin
public class TrafficController {

    @Autowired
    private TrafficService service;

    @PostMapping("/add")
    public TrafficData add(@RequestBody TrafficData data) {
        return service.save(data);
    }

    @GetMapping("/all")
    public List<TrafficData> getAll() {
        return service.getAll();
    }
}
