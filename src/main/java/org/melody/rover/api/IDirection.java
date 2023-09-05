package org.melody.rover.api;

public interface IDirection {
    void rotateLeft();

    void rotateRight();

    public Position getNextMove(Position position);
}
