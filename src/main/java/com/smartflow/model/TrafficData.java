package com.smartflow.model;

import jakarta.persistence.*;

@Entity
public class TrafficData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private int vehicleCount;
    private String signalStatus;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public int getVehicleCount() { return vehicleCount; }
    public void setVehicleCount(int vehicleCount) { this.vehicleCount = vehicleCount; }

    public String getSignalStatus() { return signalStatus; }
    public void setSignalStatus(String signalStatus) { this.signalStatus = signalStatus; }
}
