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
        AircraftQueueManager.getInstance().aqmRequestProcess(new StopRequest());
        AircraftQueue.getInstance().clear();
    }

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
	public void startRequestShallStartTheSystem() {
	    final AircraftQueue queue = AircraftQueue.getInstance(); 	    
	    
	    // ~given
	    assertThat(queue.isRunning(), equalTo(false));
	    
	    // ~when
	    AircraftQueueManager.getInstance().aqmRequestProcess(new StartRequest());
	    
	    // ~then
	    assertThat(queue.isRunning(), equalTo(true));
	}
	
    @Test
    public void stopRequestShallStopTheSystem() {
        final AircraftQueue queue = AircraftQueue.getInstance();        
        AircraftQueueManager.getInstance().aqmRequestProcess(new StartRequest());

        // ~given
        assertThat(queue.isRunning(), equalTo(true));

        // ~when
        AircraftQueueManager.getInstance().aqmRequestProcess(new StopRequest());
        
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
        AircraftQueueManager.getInstance().aqmRequestProcess(request);
        
        // ~then
        // exception is thrown
    }

    @Test
    public void enqueueRequestShallEnqueueToQueueWhenSystemIsRunning() {
        final AircraftQueue queue = AircraftQueue.getInstance();
        final AircraftProperties properties = new AircraftProperties();
        properties.setType(AircraftType.CARGO);
        properties.setSize(AircraftSize.LARGE);

        // ~given
        AircraftQueueManager.getInstance().aqmRequestProcess(new StartRequest());
        assertThat(queue.isEmpty(), equalTo(true));
        
        // ~when
        AircraftQueueManager.getInstance().aqmRequestProcess(
            new EnqueueRequest(new Aircraft(properties))
        );

        // ~then
        assertThat(queue.isEmpty(), equalTo(false));
    }

    @Test(expected=Exception.class)
    public void dequeueShallThrowExceptionIfSystemIsNotRunning() {
        // ~given
        final DequeueRequest request = new DequeueRequest();
        
        // ~when
        AircraftQueueManager.getInstance().aqmRequestProcess(request);
        
        // ~then
        // exception is thrown        
    }

    @Test
    public void dequeueRequestShallDequeueFromQueueWhenSystemIsRunning() {
        final AircraftProperties properties = new AircraftProperties();
        properties.setType(AircraftType.CARGO);
        properties.setSize(AircraftSize.LARGE);

        final AircraftQueue queue = AircraftQueue.getInstance();
        final AircraftQueueManager manager = AircraftQueueManager.getInstance(); 
        manager.aqmRequestProcess(new StartRequest());
        manager.aqmRequestProcess(new EnqueueRequest(new Aircraft(properties)));

        // ~given
        assertThat(queue.isEmpty(), equalTo(false));

        // ~when
        AircraftQueueManager.getInstance().aqmRequestProcess(new DequeueRequest());
        
        // ~then
        assertThat(queue.isEmpty(), equalTo(true));
    }
}