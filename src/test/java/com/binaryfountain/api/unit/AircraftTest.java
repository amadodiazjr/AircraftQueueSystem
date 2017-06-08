package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;

public class AircraftTest {

	@Test
	public void constructorShallCreateAnInstance() {
		// ~given
		Aircraft aircraft = null;
		
		// ~when
		aircraft = new Aircraft();
		
		// ~then
		assertThat(aircraft, notNullValue());
	}
}