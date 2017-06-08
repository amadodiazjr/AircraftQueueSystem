package com.binaryfountain.api;

import org.apache.commons.lang3.Validate;

public class Aircraft {
	private final AircraftType type;
	private final AircraftSize size;
	
	public Aircraft(final AircraftProperties properties) {
		Validate.notNull(properties, "properties cannot be null.");

		type = properties.getType();
		Validate.notNull(type, "type cannot be null.");
		
		size = properties.getSize();
		Validate.notNull(size, "size cannot be null.");
	}
	
	public AircraftType getType() {
		return type;
	}
	
	public AircraftSize getSize() {
		return size;
	}
}