package org.melody.rover;

public class RectangularGridShape implements IGridShape {

    int lowerLeftX, lowerLeftY, upperRightX, upperRightY;

    public RectangularGridShape (int width, int height) {
        lowerLeftX = lowerLeftY = 0;
        upperRightX = width;
        upperRightY = height;
    }

    @Override
    public boolean isPositionInShapeBoundary(Position position) {
        return false;
    }
}
