package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.Map;
import java.util.UUID;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;
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
	
	@Test
	public void getAircraftsShallReturnAircrafts() {
		// ~given
		Map<UUID, Aircraft> aircrafts = null;
		
		// ~when
		aircrafts = AircraftQueueManager.getInstance().getAircrafts();
		
		// ~then
		assertThat(aircrafts, notNullValue());
	}
}