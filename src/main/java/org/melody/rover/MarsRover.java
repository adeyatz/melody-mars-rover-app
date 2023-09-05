package org.melody.rover;

import org.melody.rover.api.IRotator;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

public class MarsRover extends Vehicle {

    protected static final String MARS_ROVER = "Mars Rover";
    public MarsRover(Position position, IRotator direction) {
        super(position, direction, MARS_ROVER);
    }


    public MarsRover (int x, int y, IRotator.Heading heading) {
        super (new CartesianPosition( x, y), new Compass(heading), MARS_ROVER);
    }

    public MarsRover(Position position, IRotator direction, String type) {
        super(position, direction, type);
    }

    @Override
    public boolean move() {

        this.position = getNextPosition();

        return true;
    }
}
