package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.AircraftQueueManager;

public class AircraftQueueManagerTest {

	@Test
	public void getInstanceShallReturnInstance() {
		// ~given
		AircraftQueueManager manager = null;
		
		// ~when
		manager = AircraftQueueManager.getInstance();

		// ~then
		assertThat(manager, notNullValue());
	}
}