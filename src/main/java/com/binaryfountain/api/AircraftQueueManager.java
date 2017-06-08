package com.binaryfountain.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.Validate;

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

    public void enqueue(final Aircraft aircraft) {
        Validate.notNull(aircraft, "aircraft cannot be null.");

        final AircraftType type = aircraft.getType();
        final AircraftSize size = aircraft.getSize();

        final BucketType bucketType = BucketType.parseType(type, size);
        Validate.notNull(bucketType, "bucketType cannot be null.");

        switch (bucketType) {
            case CARGO_AND_SMALL:
                cargoSmallAircrafts.add(aircraft);
                break;
            case CARGO_AND_LARGE:
                cargoLargeAircrafts.add(aircraft);
                break;
            case PASSENGER_AND_SMALL:
                passengerSmallAircrafts.add(aircraft);
                break;
            case PASSENGER_AND_LARGE:
                passengerLargeAircrafts.add(aircraft);
                break;
        }
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