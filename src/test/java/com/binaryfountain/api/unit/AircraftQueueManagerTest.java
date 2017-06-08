package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftQueueManager;
import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;

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
    
    @Test
    public void enqueueShallAddToCargoAndSmallAircraftsWhenAircraftIsCargoAndSmall() {
        final List<Aircraft> aircrafts = AircraftQueueManager.getInstance().getCargoSmallAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueueManager.getInstance().enqueue(new Aircraft(AircraftType.CARGO, AircraftSize.SMALL));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }

    @Test
    public void enqueueShallAddToCargoAndLargeAircraftsWhenAircraftIsCargoAndLarge() {
        final List<Aircraft> aircrafts = AircraftQueueManager.getInstance().getCargoLargeAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueueManager.getInstance().enqueue(new Aircraft(AircraftType.CARGO, AircraftSize.LARGE));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }
    @Test
    public void enqueueShallAddToPassengerAndSmallAircraftsWhenAircraftIsPassengerAndSmall() {
        final List<Aircraft> aircrafts = AircraftQueueManager.getInstance().getPassengerSmallAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueueManager.getInstance().enqueue(new Aircraft(AircraftType.PASSENGER, AircraftSize.SMALL));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }

    @Test
    public void enqueueShallAddToPassengerAndLargeAircraftsWhenAircraftIsPassengerAndLarge() {
        final List<Aircraft> aircrafts = AircraftQueueManager.getInstance().getPassengerLargeAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueueManager.getInstance().enqueue(new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }
}