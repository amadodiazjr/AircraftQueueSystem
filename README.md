Assignment
----------

A software subsystem of an air-traffic control system is defined to manage a queue of aircraft (AC) in an airport.  The aircraft queue is managed by a process that responds to three types of requests: 
1. System boot used to start the system.
2. Enqueue aircraft used to insert a new AC into the system. 
3. Dequeue aircraft used to remove an AC from the system.

AC’s have at least (but are not limited to having) the following properties: 
1. AC type:  Passenger or Cargo
2. AC size:  Small or Large

The process that manages the queue of AC’s satisfies the following: 
1. There is no limit to the number of AC’s it can manage.
2. Dequeue aircraft requests result in selection of one AC for removal such that:
    * Passenger AC’s have removal precedence over Cargo AC’s.
    * Large AC’s of a given type have removal precedence over Small AC’s of the same type.
    * Earlier enqueued AC’s of a given type and size have precedence over later enqueued AC’s of the same type and size.

System Implementation Requirements
1.	Develop one or more data structures to hold the state of an individual AC. 
2.	Develop one or more data structures to hold the state of the AC queue. 
3.	Define data structures and/or constants needed to represent requests.
4.	Develop the code for a procedure called aqmRequestProcess() which accepts any of the three defined requests and follows the above guidelines to implement an aircraft queue manager.  

Solution
--------

1. clone repository
2. run command: `./gradlew clean test`

All tests should pass.

All tests describe each requirement met:

https://github.com/amadodiazjr/AircraftQueueSystem/tree/master/src/test/java/com/binaryfountain/api/unit

The entire algorithm can be traced through

https://github.com/amadodiazjr/AircraftQueueSystem/blob/master/src/test/java/com/binaryfountain/api/unit/AircraftQueueTest.java#finalTest()
