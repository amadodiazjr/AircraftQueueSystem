package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftProperties;
import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;

public class AircraftTest {

	@Test(expected=Exception.class)
	public void constructorShallThrowAnErrorWhenTypeIsNull() {	    
	    // ~given
        final AircraftProperties properties = null; 

		// ~when
		new Aircraft(properties);
		
		// ~then
		// exception is thrown
	}

	@Test(expected=Exception.class)
	public void constructorShallThrowAnErrorWhenSizeIsNull() {
        final AircraftProperties properties = new AircraftProperties();

        // ~given
	    properties.setSize(null);
	    properties.setType(AircraftType.CARGO);

		// ~when
		new Aircraft(properties);
		
		// ~then
		// exception is thrown
	}

	@Test
	public void constructorShallCreateAnInstanceWhenTypeAndSizeAreNotNull() {
        final AircraftProperties properties = new AircraftProperties();

        // ~given
        properties.setSize(AircraftSize.SMALL);
        properties.setType(AircraftType.CARGO);
		
		// ~when
		final Aircraft aircraft = new Aircraft(properties);
		
		// ~then
		assertThat(aircraft, notNullValue());
	}
}