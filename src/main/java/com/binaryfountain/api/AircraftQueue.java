package com.binaryfountain.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

public class AircraftQueue {
    private final Map<BucketType, List<Aircraft>> aircraftBuckets;
    private final List<BucketType> order;
    
    private static class QueueHolder {
        private static final AircraftQueue INSTANCE = new AircraftQueue();
    }

    public static AircraftQueue getInstance() {
        return QueueHolder.INSTANCE;
    }

    private AircraftQueue() {
        aircraftBuckets = new HashMap<>();
        aircraftBuckets.put(BucketType.CARGO_AND_SMALL, new ArrayList<>());
        aircraftBuckets.put(BucketType.CARGO_AND_LARGE, new ArrayList<>());
        aircraftBuckets.put(BucketType.PASSENGER_AND_SMALL, new ArrayList<>());
        aircraftBuckets.put(BucketType.PASSENGER_AND_LARGE, new ArrayList<>());
        
        order = Arrays.asList(
            BucketType.PASSENGER_AND_LARGE,
            BucketType.PASSENGER_AND_SMALL,
            BucketType.CARGO_AND_LARGE,
            BucketType.CARGO_AND_SMALL
        );
    }

    public void enqueue(final Aircraft aircraft) {
        Validate.notNull(aircraft, "aircraft cannot be null.");

        final AircraftType type = aircraft.getType();
        final AircraftSize size = aircraft.getSize();

        final BucketType bucketType = BucketType.parseType(type, size);
        Validate.notNull(bucketType, "bucketType cannot be null.");

        aircraftBuckets.get(bucketType).add(aircraft);
    }

    public Aircraft dequeue() {
        for (final BucketType o : order) {
            final List<Aircraft> bucket = aircraftBuckets.get(o);
            if (!bucket.isEmpty()) {
                return bucket.remove(0);
            }
        }

        return null;
    }

    public Boolean isEmpty() {
        for (final BucketType o : order) {
            final List<Aircraft> bucket = aircraftBuckets.get(o);
            if (!bucket.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public Integer getSize() {
        Integer size = 0;

        for (final BucketType o : order) {
            size = size + aircraftBuckets.get(o).size();
        }
        
        return size;
    }

    public void clear() {
        order.forEach(o -> aircraftBuckets.get(o).clear());
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