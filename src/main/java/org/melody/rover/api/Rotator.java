package org.melody.rover.api;

public abstract class Rotator {
    public enum Heading { NORTH, EAST, SOUTH, WEST}

    abstract public Heading getHeading();

    abstract public void rotateLeft();

    abstract public void rotateRight();
}
