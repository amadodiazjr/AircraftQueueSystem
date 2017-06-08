package com.binaryfountain.api;

public enum BucketType {
    CARGO_AND_SMALL,
    CARGO_AND_LARGE,
    PASSENGER_AND_SMALL,
    PASSENGER_AND_LARGE;

    public static BucketType parseType(final AircraftType type, final AircraftSize size) {
        switch(type) {
            case CARGO:
                switch (size) {
                    case SMALL:
                        return CARGO_AND_SMALL;
                    case LARGE:
                        return CARGO_AND_LARGE;
                }
                break;
            case PASSENGER:
                switch (size) {
                    case SMALL:
                        return PASSENGER_AND_SMALL;
                    case LARGE:
                        return PASSENGER_AND_LARGE;
                }
                break;
        }
        
        return null;
    }
}
