package com.binaryfountain.api;

import org.apache.commons.lang3.Validate;

public class Aircraft {
	private final AircraftType type;
	private final AircraftSize size;
	
	public Aircraft(final AircraftType type, final AircraftSize size) {
		Validate.notNull(type, "type cannot be null.");
		Validate.notNull(size, "size cannot be null.");

		this.type = type;
		this.size = size;
	}
	
	public AircraftType getType() {
		return type;
	}
	
	public AircraftSize getSize() {
		return size;
	}
}