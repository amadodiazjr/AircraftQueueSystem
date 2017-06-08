package com.binaryfountain.api.unit;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.binaryfountain.api.AircraftProperties;

public class AircraftPropertiesTest {

    @Test
    public void constructorShallCreateAnInstance() {
        // ~given
        AircraftProperties properties = null;
        
        // ~when
        properties = new AircraftProperties();
        
        // ~then
        assertThat(properties, notNullValue());
    }
}