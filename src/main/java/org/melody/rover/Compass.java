package org.melody.rover;

public class Compass implements IDirection {

    public enum Bearing { NORTH, EAST, SOUTH, WEST}

    Bearing bearing;

    public Compass (Bearing bearing) {
        this.bearing = bearing;
    }
    @Override
    public void rotateLeft() {

    }

    @Override
    public void rotateRight() {

    }

    @Override
    public Position getNextMovePosition(Position currentPosition) {
        return null;
    }

    @Override
    public String toString() {
        return (bearing.toString().substring(0,1));
    }
}
