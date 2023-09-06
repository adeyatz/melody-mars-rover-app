package org.melody.rover;

import org.melody.rover.api.Position;
import org.melody.rover.api.Rotator;

class CartesianPosition extends Position {

    private int x,y;

    public CartesianPosition (int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    public boolean equals(Position position) {
        if (position instanceof CartesianPosition) {
            return (((CartesianPosition) position).x == x && ((CartesianPosition) position).y == y);
        }
        return false;
    }

    @Override
    public Position getNeighbour(Rotator.Heading rotation) {
        return  switch (rotation) {
            case NORTH -> new CartesianPosition(x, y + 1);
            case EAST -> new CartesianPosition(x + 1, y);
            case SOUTH -> new CartesianPosition(x, y - 1);
            case WEST -> new CartesianPosition(x - 1, y);
        };
    }


    @Override
    public String toString() {
        return String.format("%d %d", x, y);
    }

    @Override
    public int compareTo(Object position) {
        if (position instanceof CartesianPosition) {
            if (((CartesianPosition) position).x < x  || ((CartesianPosition) position).y < y) {
                return -1;
            } else if (((CartesianPosition) position).x > x || ((CartesianPosition) position).y > y) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }
}
