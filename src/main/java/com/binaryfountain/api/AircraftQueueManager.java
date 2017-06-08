package com.binaryfountain.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

public class AircraftQueueManager {
    private final Map<BucketType, List<Aircraft>> aircraftBuckets;
    
    private static class ManagerHolder {
        private static final AircraftQueueManager INSTANCE = new AircraftQueueManager();
    }

    public static AircraftQueueManager getInstance() {
        return ManagerHolder.INSTANCE;
    }

    private AircraftQueueManager() {
        aircraftBuckets = new HashMap<>();
        aircraftBuckets.put(BucketType.CARGO_AND_SMALL, new ArrayList<>());
        aircraftBuckets.put(BucketType.CARGO_AND_LARGE, new ArrayList<>());
        aircraftBuckets.put(BucketType.PASSENGER_AND_SMALL, new ArrayList<>());
        aircraftBuckets.put(BucketType.PASSENGER_AND_LARGE, new ArrayList<>());
    }

    public void enqueue(final Aircraft aircraft) {
        Validate.notNull(aircraft, "aircraft cannot be null.");

        final AircraftType type = aircraft.getType();
        final AircraftSize size = aircraft.getSize();

        final BucketType bucketType = BucketType.parseType(type, size);
        Validate.notNull(bucketType, "bucketType cannot be null.");

        aircraftBuckets.get(bucketType).add(aircraft);
    }

    public List<Aircraft> getCargoSmallAircrafts() {
        return aircraftBuckets.get(BucketType.CARGO_AND_SMALL);
    }

    public List<Aircraft> getCargoLargeAircrafts() {
        return aircraftBuckets.get(BucketType.CARGO_AND_LARGE);
    }

    public List<Aircraft> getPassengerSmallAircrafts() {
        return aircraftBuckets.get(BucketType.PASSENGER_AND_SMALL);
    }

    public List<Aircraft> getPassengerLargeAircrafts() {
        return aircraftBuckets.get(BucketType.PASSENGER_AND_LARGE);
    }
}