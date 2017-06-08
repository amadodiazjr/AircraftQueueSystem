package com.binaryfountain.api;

public class StartRequest implements Request {

    @Override
    public void process() {
        AircraftQueue.getInstance().start();
    }
}