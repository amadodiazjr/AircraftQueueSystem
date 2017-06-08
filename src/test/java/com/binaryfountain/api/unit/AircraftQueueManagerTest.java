package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.binaryfountain.api.Aircraft;
import com.binaryfountain.api.AircraftProperties;
import com.binaryfountain.api.AircraftQueue;
import com.binaryfountain.api.AircraftQueueManager;
import com.binaryfountain.api.AircraftSize;
import com.binaryfountain.api.AircraftType;
import com.binaryfountain.api.DequeueRequest;
import com.binaryfountain.api.EnqueueRequest;
import com.binaryfountain.api.StartRequest;
import com.binaryfountain.api.StopRequest;

public class AircraftQueueManagerTest {

    @Before
    public void doThisBeforeEachTest() {
        AircraftQueue.getInstance().stop();
        AircraftQueue.getInstance().clear();
    }

	@Test
	public void constructorShallCreateInstance() {
		// ~given
		AircraftQueueManager manager = null;
		
		// ~when
		manager = new AircraftQueueManager();

		// ~then
		assertThat(manager, notNullValue());
	}
	
	@Test
	public void startRequestShallStartTheSystem() {
	    final AircraftQueue queue = AircraftQueue.getInstance(); 	    
	    
	    // ~given
	    assertThat(queue.isRunning(), equalTo(false));
	    
	    // ~when
	    new AircraftQueueManager().aqmRequestProcess(new StartRequest());
	    
	    // ~then
	    assertThat(queue.isRunning(), equalTo(true));
	}
	
    @Test
    public void stopRequestShallStopTheSystem() {
        final AircraftQueue queue = AircraftQueue.getInstance();
        final AircraftQueueManager manager = new AircraftQueueManager();
        manager.aqmRequestProcess(new StartRequest());

        // ~given
        assertThat(queue.isRunning(), equalTo(true));

        // ~when
        manager.aqmRequestProcess(new StopRequest());
        
        // ~then
        assertThat(queue.isRunning(), equalTo(false));
    }
    
    @Test(expected=Exception.class)
    public void enqueueRequestShallThrowExceptionIfSystemIsNotRunning() {
        final AircraftProperties properties = new AircraftProperties();
        properties.setType(AircraftType.CARGO);
        properties.setSize(AircraftSize.LARGE);

        // ~given
        final EnqueueRequest request = new EnqueueRequest(new Aircraft(properties));

        // ~when
        new AircraftQueueManager().aqmRequestProcess(request);
        
        // ~then
        // exception is thrown
    }

    @Test
    public void enqueueRequestShallEnqueueToQueueWhenSystemIsRunning() {
        final AircraftQueueManager manager = new AircraftQueueManager();
        final AircraftQueue queue = AircraftQueue.getInstance();
        final AircraftProperties properties = new AircraftProperties();
        properties.setType(AircraftType.CARGO);
        properties.setSize(AircraftSize.LARGE);

        // ~given
        manager.aqmRequestProcess(new StartRequest());
        assertThat(queue.isEmpty(), equalTo(true));
        
        // ~when
        manager.aqmRequestProcess(new EnqueueRequest(new Aircraft(properties)));

        // ~then
        assertThat(queue.isEmpty(), equalTo(false));
    }

    @Test(expected=Exception.class)
    public void dequeueShallThrowExceptionIfSystemIsNotRunning() {
        // ~given
        final DequeueRequest request = new DequeueRequest();
        
        // ~when
        new AircraftQueueManager().aqmRequestProcess(request);
        
        // ~then
        // exception is thrown        
    }

    @Test
    public void dequeueRequestShallDequeueFromQueueWhenSystemIsRunning() {
        final AircraftProperties properties = new AircraftProperties();
        properties.setType(AircraftType.CARGO);
        properties.setSize(AircraftSize.LARGE);

        final AircraftQueue queue = AircraftQueue.getInstance();
        final AircraftQueueManager manager = new AircraftQueueManager(); 
        manager.aqmRequestProcess(new StartRequest());
        manager.aqmRequestProcess(new EnqueueRequest(new Aircraft(properties)));

        // ~given
        assertThat(queue.isEmpty(), equalTo(false));

        // ~when
        manager.aqmRequestProcess(new DequeueRequest());
        
        // ~then
        assertThat(queue.isEmpty(), equalTo(true));
    }
}