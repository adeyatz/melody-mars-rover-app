package org.melody.rover;

class CartesianPosition extends Position {

    private int x,y;

    public CartesianPosition (int x, int y){
        this.x = x;
        this.y = y;
    }


    @Override
    protected boolean equals(Position other) {
        return (((CartesianPosition) other).x == x && ((CartesianPosition) other).y == y);
    }

    @Override
    protected Position getAdjacent(Adjacent direction) {
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
    public int compareTo(Object o) {
        return 0;
    }
}
