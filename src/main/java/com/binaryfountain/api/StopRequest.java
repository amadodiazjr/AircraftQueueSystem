package com.binaryfountain.api;

public class StopRequest implements Request {

    @Override
    public void process() {
        AircraftQueue.getInstance().stop();
    }
}