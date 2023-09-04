package org.melody.rover;

public abstract class Position implements Comparable {

    public enum Adjacent {
        N, NE, E, SE, S, SW, W, NW
    }

    public final boolean equals(Object other) {
        if (other == null) {
            return false;
        } else if (other == this) {
            return true;
        }

        if (other instanceof Position) {
            return equals((Position) other);
        }
        return false;
    }

    protected abstract boolean equals(Position other);

    protected abstract Position getAdjacent(Adjacent direction);

    public abstract String toString();
}
