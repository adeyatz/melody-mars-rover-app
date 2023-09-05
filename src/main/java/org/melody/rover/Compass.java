package org.melody.rover;

import org.melody.rover.api.IDirection;
import org.melody.rover.api.Position;

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
    public Position getNextMove(Position currentPosition) {
        Position nextPosition = switch (bearing) {
            case NORTH -> currentPosition.getNextDoor(Position.NextDoor.N);
            case EAST -> currentPosition.getNextDoor(Position.NextDoor.E);
            case SOUTH -> currentPosition.getNextDoor(Position.NextDoor.S);
            case WEST -> currentPosition.getNextDoor(Position.NextDoor.W);
        };
        return nextPosition;
    }


    @Override
    public String toString() {
        return (bearing.toString().substring(0,1));
    }
}
