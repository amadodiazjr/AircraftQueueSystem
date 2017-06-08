package com.binaryfountain.api;

public class AircraftProperties {
    private AircraftType type;
    private AircraftSize size;

    public AircraftProperties() {
        setType(null);
        setSize(null);
    }

    public AircraftProperties setSize(AircraftSize size) {
        this.size = size;
        return this;
    }    

    public AircraftProperties setType(AircraftType type) {
        this.type = type;
        return this;
    }

    public AircraftType getType() {
        return type;
    }

    public AircraftSize getSize() {
        return size;
    }
}