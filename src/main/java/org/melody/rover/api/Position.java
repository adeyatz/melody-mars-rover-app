package org.melody.rover.api;

public abstract class Position {

    public enum NextDoor {
        N, NE, E, SE, S, SW, W, NW
    }

    public final boolean equals(Object position) {
        if (position == null) {
            return false;
        } else if (position == this) {
            return true;
        }

        if (position instanceof Position) {
            return equals((Position) position);
        }
        return false;
    }

    public abstract boolean equals(Position other);

    public abstract Position getNextDoor(NextDoor direction);

    public abstract String toString();
}
