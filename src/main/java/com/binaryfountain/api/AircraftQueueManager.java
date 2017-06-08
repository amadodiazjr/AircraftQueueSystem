package com.binaryfountain.api;

import java.util.ArrayList;
import java.util.List;

public class AircraftQueueManager {
    private final List<Aircraft> cargoSmallAircrafts;
    private final List<Aircraft> cargoLargeAircrafts;
    private final List<Aircraft> passengerSmallAircrafts;
    private final List<Aircraft> passengerLargeAircrafts;

    private static class ManagerHolder {
        private static final AircraftQueueManager INSTANCE = new AircraftQueueManager();
    }

    public static AircraftQueueManager getInstance() {
        return ManagerHolder.INSTANCE;
    }

    private AircraftQueueManager() {
        cargoSmallAircrafts = new ArrayList<>();
        cargoLargeAircrafts = new ArrayList<>();
        passengerSmallAircrafts = new ArrayList<>();
        passengerLargeAircrafts = new ArrayList<>();
    }

    public void enqueue() {
        
    }

    public List<Aircraft> getCargoSmallAircrafts() {
        return cargoSmallAircrafts;
    }

    public List<Aircraft> getCargoLargeAircrafts() {
        return cargoLargeAircrafts;
    }

    public List<Aircraft> getPassengerSmallAircrafts() {
        return passengerSmallAircrafts;
    }

    public List<Aircraft> getPassengerLargeAircrafts() {
        return passengerLargeAircrafts;
    }

}