package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;
import com.binaryfountain.api.BucketType;

public class BucketTypeTest {

	@Test
	public void parseTypeShallReturnCargoAndSmallWhenCargoAndSmallIsProvided() {
		// ~given
		final AircraftType type = AircraftType.CARGO;
        final AircraftSize size = AircraftSize.SMALL;
		
		// ~when
		final BucketType bucketType = BucketType.parseType(type, size);
		
		// ~then
		assertThat(bucketType.equals(BucketType.CARGO_AND_SMALL), equalTo(true));
	}

    @Test
    public void parseTypeShallReturnCargoAndLargeWhenCargoAndLargeIsProvided() {
        // ~given
        final AircraftType type = AircraftType.CARGO;
        final AircraftSize size = AircraftSize.LARGE;
        
        // ~when
        final BucketType bucketType = BucketType.parseType(type, size);
        
        // ~then
        assertThat(bucketType.equals(BucketType.CARGO_AND_LARGE), equalTo(true));
    }

    @Test
    public void parseTypeShallReturnPassengerAndSmallWhenCargoAndSmallIsProvided() {
        // ~given
        final AircraftType type = AircraftType.PASSENGER;
        final AircraftSize size = AircraftSize.SMALL;
        
        // ~when
        final BucketType bucketType = BucketType.parseType(type, size);
        
        // ~then
        assertThat(bucketType.equals(BucketType.PASSENGER_AND_SMALL), equalTo(true));
    }

    @Test
    public void parseTypeShallReturnPassengerAndLargeWhenCargoAndLargeIsProvided() {
        // ~given
        final AircraftType type = AircraftType.PASSENGER;
        final AircraftSize size = AircraftSize.LARGE;
        
        // ~when
        final BucketType bucketType = BucketType.parseType(type, size);
        
        // ~then
        assertThat(bucketType.equals(BucketType.PASSENGER_AND_LARGE), equalTo(true));
    }
}