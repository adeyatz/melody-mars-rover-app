package org.melody.rover.api;

public interface IRotator {
    public enum Heading { NORTH, EAST, SOUTH, WEST}

    void rotateLeft();

    void rotateRight();

    Heading getHeading();

}
