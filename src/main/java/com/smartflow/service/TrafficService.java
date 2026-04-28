package com.smartflow.service;

import com.smartflow.model.TrafficData;
import com.smartflow.repository.TrafficRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficService {

    @Autowired
    private TrafficRepository repo;

    // 🚦 SAVE WITH IMPROVED AI LOGIC
    public TrafficData save(TrafficData data) {

        int speed = data.getVehicleCount();

        // 🔹 AUTO PROCESS STATUS (SMART LEVELS)
        if (data.getProcessStatus() == null || data.getProcessStatus().isEmpty()) {

            if (speed > 120) {
                data.setProcessStatus("Critical");
            } else if (speed > 80) {
                data.setProcessStatus("Overload");
            } else if (speed > 40) {
                data.setProcessStatus("Moderate");
            } else {
                data.setProcessStatus("Normal");
            }
        }

        // 🔹 AI SIGNAL CONTROL
        if ("Priority".equalsIgnoreCase(data.getProcessStatus())) {
            data.setSignalStatus("Green");  // Emergency always green
        }
        else if (speed > 120) {
            data.setSignalStatus("Red");    // Critical traffic
        }
        else if (speed > 80) {
            data.setSignalStatus("Red");    // Heavy traffic
        }
        else if (speed > 40) {
            data.setSignalStatus("Yellow"); // Medium traffic
        }
        else {
            data.setSignalStatus("Green");  // Normal traffic
        }

        return repo.save(data);
    }

    // ✅ GET ALL DATA
    public List<TrafficData> getAll() {
        return repo.findAll();
    }

    // ✅ DELETE ALL DATA
    public void deleteAll() {
        repo.deleteAll();
    }
}