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

        int traffic = data.getVehicleCount();

        // 🔴 PRIORITY CHECK FIRST (IMPORTANT)
        if ("Priority".equalsIgnoreCase(data.getProcessStatus())) {
            data.setProcessStatus("Priority");
            data.setSignalStatus("Green");   // Emergency override
            return repo.save(data);
        }

        // 🔹 AUTO PROCESS STATUS (SMART LEVELS)
        if (data.getProcessStatus() == null || data.getProcessStatus().isEmpty()) {

            if (traffic > 120) {
                data.setProcessStatus("Critical");
            } else if (traffic > 80) {
                data.setProcessStatus("Overload");
            } else if (traffic > 40) {
                data.setProcessStatus("Moderate");
            } else {
                data.setProcessStatus("Normal");
            }
        }

        // 🔹 AI SIGNAL CONTROL (CLEAN LOGIC)
        switch (data.getProcessStatus()) {

            case "Critical":
            case "Overload":
                data.setSignalStatus("Red");
                break;

            case "Moderate":
                data.setSignalStatus("Yellow");
                break;

            default:
                data.setSignalStatus("Green");
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