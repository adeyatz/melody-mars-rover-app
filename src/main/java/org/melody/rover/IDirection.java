package org.melody.rover;

public interface IDirection {
    void rotateLeft();

    void rotateRight();

    Position getNextMovePosition (Position currentPosition);
}
