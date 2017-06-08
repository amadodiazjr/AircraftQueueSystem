package com.binaryfountain.api;

import org.apache.commons.lang3.Validate;

public class EnqueueRequest implements Request {
    private final Aircraft aircraft;
    
    public EnqueueRequest(final Aircraft aircraft) {
        Validate.notNull(aircraft, "aircraft cannot be null.");

        this.aircraft = aircraft;
    }

    @Override
    public void process() {
        Validate.isTrue(AircraftQueue.getInstance().isRunning(), "system is not running.");

        AircraftQueue.getInstance().enqueue(aircraft);
    }
}