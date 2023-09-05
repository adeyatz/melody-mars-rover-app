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
    void testPositionInPlateauBoundary() {

        IPlateauBoundary plateau = new RectangularCartesianPlateau(5,5);

        Position position = new CartesianPosition(0,0);
        assertTrue(plateau.isPositionInPlateauBoundary(position));

        position = new CartesianPosition(5,5);
        assertTrue(plateau.isPositionInPlateauBoundary(position));

        position = new CartesianPosition(0,5);
        assertTrue(plateau.isPositionInPlateauBoundary(position));

        position = new CartesianPosition(5,0);
        assertTrue(plateau.isPositionInPlateauBoundary(position));


        position = new CartesianPosition(-1,0);
        assertFalse (plateau.isPositionInPlateauBoundary(position));

        position = new CartesianPosition(0,-1);
        assertFalse (plateau.isPositionInPlateauBoundary(position));

        position = new CartesianPosition(6,5);
        assertFalse(plateau.isPositionInPlateauBoundary(position));

        position = new CartesianPosition(5,6);
        assertFalse(plateau.isPositionInPlateauBoundary(position));
    }
}