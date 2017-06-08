package com.binaryfountain.api;

public enum BucketType {
    CARGO_AND_SMALL,
    CARGO_AND_LARGE,
    PASSENGER_AND_SMALL,
    PASSENGER_AND_LARGE;

    public static BucketType parseType(final AircraftType type, final AircraftSize size) {
        switch(type) {
            case CARGO:
                if (size.equals(AircraftSize.SMALL)) {
                    return CARGO_AND_SMALL;
                }
    
                if (size.equals(AircraftSize.LARGE)) {
                    return CARGO_AND_LARGE;
                }
                break;
            case PASSENGER:
                if (size.equals(AircraftSize.SMALL)) {
                    return PASSENGER_AND_SMALL;
                }
    
                if (size.equals(AircraftSize.LARGE)) {
                    return PASSENGER_AND_LARGE;
                }
                break;
        }
        
        return null;
    }
}
