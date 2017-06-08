package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftProperties;
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
        final AircraftProperties properties = new AircraftProperties();
        properties.setType(AircraftType.CARGO);
        properties.setSize(AircraftSize.LARGE);

	    // ~given
        final Aircraft aircraft = new Aircraft(properties);
        
        // ~when
        final EnqueueRequest request = new EnqueueRequest(aircraft);
        
        // ~then
        assertThat(request, notNullValue());
    }
}