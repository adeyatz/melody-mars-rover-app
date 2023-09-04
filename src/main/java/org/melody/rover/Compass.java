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
        Position nextPosition = switch (bearing) {
            case NORTH -> currentPosition.getAdjacent(Position.Adjacent.N);
            case EAST -> currentPosition.getAdjacent(Position.Adjacent.E);
            case SOUTH -> currentPosition.getAdjacent(Position.Adjacent.S);
            case WEST -> currentPosition.getAdjacent(Position.Adjacent.W);
        };
        return nextPosition;
    }


    @Override
    public String toString() {
        return (bearing.toString().substring(0,1));
    }
}
