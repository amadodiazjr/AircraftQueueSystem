package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;
import com.binaryfountain.api.EnqueueRequest;

public class EnqueueRequestTest {

	@Test(expected=Exception.class)
	public void constructorShallThrowAnErrorAircraftIsNull() {
		// ~given
		final Aircraft aircraft = null;
		
		// ~when
		new EnqueueRequest(aircraft);
		
		// ~then
		// exception is thrown
	}
	
	@Test
    public void constructorShallCreateInstanceWhenAircraftIsNotNull() {
        // ~given
        final Aircraft aircraft = new Aircraft(AircraftType.CARGO, AircraftSize.LARGE);
        
        // ~when
        final EnqueueRequest request = new EnqueueRequest(aircraft);
        
        // ~then
        assertThat(request, notNullValue());
    }
}