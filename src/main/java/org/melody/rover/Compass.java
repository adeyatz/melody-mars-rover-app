package org.melody.rover;

import org.melody.rover.api.IRotator;

public class Compass implements IRotator {

    Heading bearing;

    public Compass (Heading bearing) {
        this.bearing = bearing;
    }

    public void rotateLeft() {
        bearing = switch (bearing) {
            case NORTH -> Heading.WEST;
            case WEST -> Heading.SOUTH;
            case SOUTH -> Heading.EAST;
            case EAST -> Heading.NORTH;
        };
    }


    public void rotateRight() {
        bearing = switch (bearing) {
            case NORTH -> Heading.EAST;
            case EAST -> Heading.SOUTH;
            case SOUTH -> Heading.WEST;
            case WEST -> Heading.NORTH;
        };
    }

    @Override
    public Heading getHeading() {
        return bearing;
    }

    @Override
    public String toString() {
        return (bearing.toString().substring(0,1));
    }
}
