package com.binaryfountain.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AircraftQueueManager {
    private Map<UUID, Aircraft> aircrafts;
    
    private static class ManagerHolder {
        private static final AircraftQueueManager INSTANCE = new AircraftQueueManager();
    }

    public static AircraftQueueManager getInstance() {
        return ManagerHolder.INSTANCE;
    }

    private AircraftQueueManager() {
    	aircrafts = new HashMap<>();
    }
    
    public Map<UUID, Aircraft> getAircrafts() {
    	return aircrafts;
    }
}