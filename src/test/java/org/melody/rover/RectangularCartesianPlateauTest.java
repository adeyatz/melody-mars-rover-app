package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IPlateauBoundary;
import org.melody.rover.api.Position;

import static org.junit.jupiter.api.Assertions.*;

class RectangularCartesianPlateauTest {

    @Test
    void testPlateauConstructor() {

        IPlateauBoundary plateau = new RectangularCartesianPlateau(5,5);
        assertNotNull (plateau);
    }


    @Test
    void testInvalidPlateauConstructor() {
        try {
            IPlateauBoundary plateau = new RectangularCartesianPlateau(-5, -5);
            fail("Constructor should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }


    @Test
    void isPositionInShapeBoundary() {

        IPlateauBoundary shape = new RectangularCartesianPlateau(5,5);

        Position position = new CartesianPosition(0,0);

        assertTrue(shape.isPositionInPlateauBoundary(position));
    }
}