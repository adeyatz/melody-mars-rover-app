package org.melody.rover.api;

public abstract class Position {

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

    public abstract Position getNeighbour(Rotator.Heading heading);

    public abstract String toString();

    public abstract boolean greaterOrEqual (Position other);

    public abstract boolean lessOrEqual (Position other );
}
