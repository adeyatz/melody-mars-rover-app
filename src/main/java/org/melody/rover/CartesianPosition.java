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
    protected Position getAdjacentPosition(AdjacentPositions direction) {
        return null;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
