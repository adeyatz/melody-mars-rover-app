package org.melody.rover;

import org.melody.rover.api.Rotator;

public class CompassRotator extends Rotator {

    Heading heading;

    public CompassRotator(Heading heading) {
        this.heading = heading;
    }

    public void rotateLeft() {
        heading = switch (heading) {
            case NORTH -> Heading.WEST;
            case WEST -> Heading.SOUTH;
            case SOUTH -> Heading.EAST;
            case EAST -> Heading.NORTH;
        };
    }


    public void rotateRight() {
        heading = switch (heading) {
            case NORTH -> Heading.EAST;
            case EAST -> Heading.SOUTH;
            case SOUTH -> Heading.WEST;
            case WEST -> Heading.NORTH;
        };
    }

    @Override
    public Heading getHeading() {
        return heading;
    }

    @Override
    public String toString() {
        return (heading.toString().substring(0,1));
    }
}
