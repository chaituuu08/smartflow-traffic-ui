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

    // ✅ ADD DATA
    @PostMapping("/add")
    public TrafficData add(@RequestBody TrafficData data) {

        System.out.println("Received Data:");
        System.out.println("Location: " + data.getLocation());
        System.out.println("Speed: " + data.getVehicleCount());
        System.out.println("Signal: " + data.getSignalStatus());
        System.out.println("Process: " + data.getProcessStatus());

        return service.save(data);
    }

    // ✅ GET ALL DATA
    @GetMapping("/all")
    public List<TrafficData> getAll() {
        return service.getAll();
    }

    // ✅ DELETE ALL DATA (🔥 IMPORTANT)
    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        service.deleteAll();
        return "All data deleted successfully";
    }
}