package org.melody.rover;

public class Compass implements IDirection {

    public enum Bearing { NORTH, EAST, SOUTH, WEST}

    Bearing bearing;

    public Compass (Bearing bearing) {
        this.bearing = bearing;
    }
    @Override
    public void rotateLeft() {
        bearing = switch (bearing) {
            case NORTH -> Bearing.WEST;
            case WEST -> Bearing.SOUTH;
            case SOUTH -> Bearing.EAST;
            case EAST -> Bearing.NORTH;
        };
    }

    @Override
    public void rotateRight() {
        bearing = switch (bearing) {
            case NORTH -> Bearing.EAST;
            case EAST -> Bearing.SOUTH;
            case SOUTH -> Bearing.WEST;
            case WEST -> Bearing.NORTH;
        };
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
