package org.melody.rover.api;

public interface IRotator {
    public enum Bearing { NORTH, EAST, SOUTH, WEST}

    void rotateLeft();

    void rotateRight();

    Bearing getBearing ();

}
