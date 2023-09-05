package org.melody.rover;

import org.melody.rover.api.IRotator;
import org.melody.rover.api.Position;

public class Compass implements IRotator {

    Bearing bearing;

    public Compass (Bearing bearing) {
        this.bearing = bearing;
    }

    public void rotateLeft() {
        bearing = switch (bearing) {
            case NORTH -> Bearing.WEST;
            case WEST -> Bearing.SOUTH;
            case SOUTH -> Bearing.EAST;
            case EAST -> Bearing.NORTH;
        };
    }


    public void rotateRight() {
        bearing = switch (bearing) {
            case NORTH -> Bearing.EAST;
            case EAST -> Bearing.SOUTH;
            case SOUTH -> Bearing.WEST;
            case WEST -> Bearing.NORTH;
        };
    }

    @Override
    public Bearing getBearing() {
        return bearing;
    }

    @Override
    public String toString() {
        return (bearing.toString().substring(0,1));
    }
}
