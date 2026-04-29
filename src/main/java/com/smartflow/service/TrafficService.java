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

    public TrafficData save(TrafficData data) {
        return repo.save(data);
    }

    public List<TrafficData> getAll() {
        return repo.findAll();
    }
}
