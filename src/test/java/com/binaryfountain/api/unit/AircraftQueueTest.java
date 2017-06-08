package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftQueue;
import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;

public class AircraftQueueTest {

    @Before
    public void doThisBeforeEachTest() {
        AircraftQueue.getInstance().clear();
    }
    
    @Test
    public void getInstanceShallReturnInstance() {
        // ~given
        AircraftQueue queue = null;

        // ~when
        queue = AircraftQueue.getInstance();

        // ~then
        assertThat(queue, notNullValue());
    }

    @Test
    public void getCargoSmallAircraftsShallReturnCargoSmallAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueue.getInstance().getCargoSmallAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }

    @Test
    public void getCargoLargeAircraftsShallReturnCargoLargeAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueue.getInstance().getCargoLargeAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }

    @Test
    public void getPassengerSmallAircraftsShallReturnPassengerSmallAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueue.getInstance().getPassengerSmallAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }

    @Test
    public void getPassengerLargeAircraftsShallReturnPassengerLargeAircrafts() {
        // ~given
        List<Aircraft> aircrafts = null;

        // ~when
        aircrafts = AircraftQueue.getInstance().getCargoLargeAircrafts();

        // ~then
        assertThat(aircrafts, notNullValue());
    }
    
    @Test
    public void enqueueShallAddToCargoAndSmallAircraftsWhenAircraftIsCargoAndSmall() {
        final List<Aircraft> aircrafts = AircraftQueue.getInstance().getCargoSmallAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueue.getInstance().enqueue(new Aircraft(AircraftType.CARGO, AircraftSize.SMALL));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }

    @Test
    public void enqueueShallAddToCargoAndLargeAircraftsWhenAircraftIsCargoAndLarge() {
        final List<Aircraft> aircrafts = AircraftQueue.getInstance().getCargoLargeAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueue.getInstance().enqueue(new Aircraft(AircraftType.CARGO, AircraftSize.LARGE));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }
    @Test
    public void enqueueShallAddToPassengerAndSmallAircraftsWhenAircraftIsPassengerAndSmall() {
        final List<Aircraft> aircrafts = AircraftQueue.getInstance().getPassengerSmallAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueue.getInstance().enqueue(new Aircraft(AircraftType.PASSENGER, AircraftSize.SMALL));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }

    @Test
    public void enqueueShallAddToPassengerAndLargeAircraftsWhenAircraftIsPassengerAndLarge() {
        final List<Aircraft> aircrafts = AircraftQueue.getInstance().getPassengerLargeAircrafts();

        // ~given
        assertThat(aircrafts.isEmpty(), equalTo(true));

        // ~when
        AircraftQueue.getInstance().enqueue(new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE));

        // ~then
        assertThat(aircrafts.isEmpty(), equalTo(false));
    }
    
    @Test
    public void dequeueShallReturnNullWhenAQueueIsEmpty() {
        final AircraftQueue queue = AircraftQueue.getInstance();

        // ~given
        assertThat(queue.isEmpty(), equalTo(true)); 
        
        // ~when
        final Aircraft aircraft = queue.dequeue(); 
        
        // ~then
        assertThat(aircraft, nullValue());
    }

    @Test
    public void finalTest() { // purposely vague test description (skipping to end for expediency).
        // This is all just set up.  Skip to ~given
        final Aircraft aircraft0 = new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE);
        final Aircraft aircraft1 = new Aircraft(AircraftType.CARGO, AircraftSize.LARGE);
        final Aircraft aircraft2 = new Aircraft(AircraftType.PASSENGER, AircraftSize.SMALL);
        final Aircraft aircraft3 = new Aircraft(AircraftType.CARGO, AircraftSize.LARGE);
        final Aircraft aircraft4 = new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE);
        final Aircraft aircraft5 = new Aircraft(AircraftType.CARGO, AircraftSize.SMALL);
        final Aircraft aircraft6 = new Aircraft(AircraftType.PASSENGER, AircraftSize.SMALL);
        final Aircraft aircraft7 = new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE);
        final Aircraft aircraft8 = new Aircraft(AircraftType.CARGO, AircraftSize.LARGE);
        final Aircraft aircraft9 = new Aircraft(AircraftType.CARGO, AircraftSize.LARGE);

        // This is the order I expect
        final List<Aircraft> orderedAircrafts = new ArrayList<>();
        orderedAircrafts.add(aircraft0);
        orderedAircrafts.add(aircraft4);
        orderedAircrafts.add(aircraft7);
        orderedAircrafts.add(aircraft2);
        orderedAircrafts.add(aircraft6);
        orderedAircrafts.add(aircraft1);
        orderedAircrafts.add(aircraft3);
        orderedAircrafts.add(aircraft8);
        orderedAircrafts.add(aircraft9);
        orderedAircrafts.add(aircraft5);

        final List<Aircraft> aircrafts = new ArrayList<>();
        aircrafts.add(aircraft0);
        aircrafts.add(aircraft1);
        aircrafts.add(aircraft2);
        aircrafts.add(aircraft3);
        aircrafts.add(aircraft4);
        aircrafts.add(aircraft5);
        aircrafts.add(aircraft6);
        aircrafts.add(aircraft7);
        aircrafts.add(aircraft8);
        aircrafts.add(aircraft9);

        assertThat(orderedAircrafts.size(), equalTo(aircrafts.size()));

        final AircraftQueue queue = AircraftQueue.getInstance();
        final List<Aircraft> dequedAircrafts = new ArrayList<>();

        // ~given
        aircrafts.forEach(aircraft -> queue.enqueue(aircraft));

        // ~when
        final Integer size = queue.getSize();
        for(int i=0; i<size; i++) {
            dequedAircrafts.add(queue.dequeue());
        }
      
        // ~then
        assertThat(dequedAircrafts.size(), equalTo(orderedAircrafts.size()));
        for(int i=0; i<size; i++) {
            assertThat(dequedAircrafts.get(i), equalTo(orderedAircrafts.get(i)));
        }
    }
}