package org.melody.rover.api;

public interface IMovable {
    public void move (Position newPosition);
    public void rotateLeft();

    public void rotateRight();
}
