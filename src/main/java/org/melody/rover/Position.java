package org.melody.rover;

import java.util.Comparator;

public abstract class Position implements Comparable {

    public enum AdjacentPositions {
        N, NE, E, SE, S, SW, W, NW
    }

    public final boolean equals(Object other) {
        if (other == this) {
        return true;
        }
        if (other instanceof Position) {
            return equals((Position) other);
        }
        return false;
        }

    protected abstract boolean equals(Position other);

    protected abstract Position getAdjacentPosition (AdjacentPositions direction);
}
