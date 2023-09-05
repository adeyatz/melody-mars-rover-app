package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IPlateau;
import org.melody.rover.api.Position;

import static org.junit.jupiter.api.Assertions.*;

class RectangularCartesianPlateauTest {

    @Test
    void testPlateauConstructor() {

        IPlateau plateau = new RectangularCartesianPlateau(5,5);
        assertNotNull (plateau);
    }


    @Test
    void testInvalidPlateauConstructor() {
        try {
            IPlateau plateau = new RectangularCartesianPlateau(-5, -5);
            fail("Constructor should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }


    @Test
    void testPositionInPlateauBoundary() {

        IPlateau plateau = new RectangularCartesianPlateau(5,5);

        Position position = new CartesianPosition(0,0);
        assertTrue(plateau.isPositionInBoundary(position));

        position = new CartesianPosition(5,5);
        assertTrue(plateau.isPositionInBoundary(position));

        position = new CartesianPosition(0,5);
        assertTrue(plateau.isPositionInBoundary(position));

        position = new CartesianPosition(5,0);
        assertTrue(plateau.isPositionInBoundary(position));


        position = new CartesianPosition(-1,0);
        assertFalse (plateau.isPositionInBoundary(position));

        position = new CartesianPosition(0,-1);
        assertFalse (plateau.isPositionInBoundary(position));

        position = new CartesianPosition(6,5);
        assertFalse(plateau.isPositionInBoundary(position));

        position = new CartesianPosition(5,6);
        assertFalse(plateau.isPositionInBoundary(position));
    }
}