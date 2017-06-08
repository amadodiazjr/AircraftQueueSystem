package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

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
    public void getCargoSmallAircraftsShallReturnCargoSmallAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueueManager.getInstance().getCargoSmallAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }

    @Test
    public void getCargoLargeAircraftsShallReturnCargoLargeAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueueManager.getInstance().getCargoLargeAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }

    @Test
    public void getPassengerSmallAircraftsShallReturnPassengerSmallAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueueManager.getInstance().getPassengerSmallAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }

    @Test
    public void getPassengerLargeAircraftsShallReturnPassengerLargeAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueueManager.getInstance().getCargoLargeAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }
}