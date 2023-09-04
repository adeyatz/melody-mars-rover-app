package org.melody.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularGridShapeTest {

    @Test
    void isPositionInShapeBoundary() {

        IGridShape shape = new RectangularGridShape(5,5);

        Position position = new CartesianPosition(0,0);

        assertTrue(shape.isPositionInShapeBoundary(position));
    }
}