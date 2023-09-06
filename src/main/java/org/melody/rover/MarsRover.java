package org.melody.rover;

import org.melody.rover.api.Rotator;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

public class MarsRover extends Vehicle {

    protected static final String MARS_ROVER = "Mars Rover";
    public MarsRover(Position position, Rotator rotator) {
        super(position, rotator, MARS_ROVER);
    }


    public MarsRover (int x, int y, Rotator.Heading heading) {
        super (new CartesianPosition( x, y), new CompassRotator(heading), MARS_ROVER);
    }

    public MarsRover(Position position, Rotator direction, String type) {
        super(position, direction, type);
    }

    @Override
    public void move(Position newPosition) {
        this.position = newPosition;
    }
}
