package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;

public class AircraftTest {

	@Test(expected=Exception.class)
	public void constructorShallThrowAnErrorWhenTypeIsNull() {
		// ~given
		final AircraftType type = null;
		
		// ~when
		new Aircraft(type, AircraftSize.SMALL);
		
		// ~then
		// exception is thrown
	}

	@Test(expected=Exception.class)
	public void constructorShallThrowAnErrorWhenSizeIsNull() {
		// ~given
		final AircraftSize size = null;
		
		// ~when
		new Aircraft(AircraftType.CARGO, size);
		
		// ~then
		// exception is thrown
	}

	@Test
	public void constructorShallCreateAnInstanceWhenTypeAndSizeAreNotNull() {
		// ~given
		final AircraftSize size = AircraftSize.SMALL;
		final AircraftType type = AircraftType.CARGO;
		
		// ~when
		final Aircraft aircraft = new Aircraft(type, size);
		
		// ~then
		assertThat(aircraft, notNullValue());
	}
}