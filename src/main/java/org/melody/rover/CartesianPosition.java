package org.melody.rover;

import org.melody.rover.api.Position;

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
    public Position getNextDoor(NextDoor direction) {
        Position result = switch (direction) {
            case N -> new CartesianPosition(x, y + 1);

            case NE -> new CartesianPosition(x + 1, y + 1);

            case E -> new CartesianPosition(x + 1, y);

            case SE -> new CartesianPosition(x + 1, y - 1);

            case S -> new CartesianPosition(x, y - 1);

            case SW -> new CartesianPosition(x - 1, y - 1);

            case W -> new CartesianPosition(x - 1, y);

            case NW -> new CartesianPosition(x - 1, y + 1);

        };

        return result;
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
