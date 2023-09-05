package org.melody.rover;

import org.melody.rover.api.IRotator;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

public class MarsRover extends Vehicle {

    protected static final String MARS_ROVER = "Mars Rover";
    public MarsRover(Position position, IRotator direction) {
        super(position, direction, MARS_ROVER);
    }

    @Override
    public boolean move() {

        this.position = getNextPosition();

        return true;
    }
}
