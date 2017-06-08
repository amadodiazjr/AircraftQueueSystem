package com.binaryfountain.api;

import org.apache.commons.lang3.Validate;

public class DequeueRequest implements Request {

    @Override
    public void process() {
        Validate.isTrue(AircraftQueue.getInstance().isRunning(), "system is not running.");

        AircraftQueue.getInstance().dequeue();
    }
}