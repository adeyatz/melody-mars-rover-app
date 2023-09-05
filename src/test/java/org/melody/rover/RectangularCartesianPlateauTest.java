package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IPlateauBoundary;
import org.melody.rover.api.Position;

import static org.junit.jupiter.api.Assertions.*;

class RectangularCartesianPlateauTest {

    @Test
    void isPositionInShapeBoundary() {

        IPlateauBoundary shape = new RectangularCartesianPlateau(5,5);

        Position position = new CartesianPosition(0,0);

        assertTrue(shape.isPositionInPlateauBoundary(position));
    }
}