package com.binaryfountain.api;

public class AircraftQueueManager {

    private static class ManagerHolder {
        private static final AircraftQueueManager INSTANCE = new AircraftQueueManager();
    }

    public static AircraftQueueManager getInstance() {
        return ManagerHolder.INSTANCE;
    }

    private AircraftQueueManager() { }

    public void aqmRequestProcess(final Request request) {
        request.process();
    }
}