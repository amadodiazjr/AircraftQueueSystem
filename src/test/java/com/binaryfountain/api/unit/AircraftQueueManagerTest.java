package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;

public class AircraftQueueManagerTest {

	@Test
	public void constructorShallCreateAnInstanceWhenTypeAndSizeAreNotNull() {
		// ~given
		AircraftQueueManager manager = null;
	    final AircraftSize size = AircraftSize.SMALL;
		final AircraftType type = AircraftType.CARGO;
		
		// ~when
		final Aircraft aircraft = new Aircraft(type, size);
		
		// ~then
		assertThat(manager, notNullValue());
	}
}