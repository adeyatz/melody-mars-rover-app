package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Position;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testPlateauConstructor() {

        ICheckPosition plateau = new RectangularCartesianPlateau(5,5);
        assertNotNull (plateau);
    }


    @Test
    void testInvalidPlateauConstructor() {
        try {
            ICheckPosition plateau = new RectangularCartesianPlateau(-5, -5);
            fail("Constructor should throw IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }


    @Test
    void testPositionInPlateauBoundary() {

        ICheckPosition plateau = new RectangularCartesianPlateau(5,5);

        Position position = new CartesianPosition(0,0);
        assertTrue(plateau.canUsePosition(position));

        position = new CartesianPosition(5,5);
        assertTrue(plateau.canUsePosition(position));

        position = new CartesianPosition(0,5);
        assertTrue(plateau.canUsePosition(position));

        position = new CartesianPosition(5,0);
        assertTrue(plateau.canUsePosition(position));


        position = new CartesianPosition(-1,0);
        assertFalse (plateau.canUsePosition(position));

        position = new CartesianPosition(0,-1);
        assertFalse (plateau.canUsePosition(position));

        position = new CartesianPosition(6,5);
        assertFalse(plateau.canUsePosition(position));

        position = new CartesianPosition(5,6);
        assertFalse(plateau.canUsePosition(position));
    }
}