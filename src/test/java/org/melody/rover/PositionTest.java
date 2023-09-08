package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.Position;
import org.melody.rover.api.Rotator;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void testCartesianPositionConstructor() {

        Position position = new CartesianPosition(0,0);
        assertNotNull( position );
    }

    @Test
    void testEqualsCartesianPosition() {
        Position p1 = new CartesianPosition(0, 0);
        Position p2 = new CartesianPosition( 0, 0);

        assertEquals( p1, p1);  // Same object
        assertEquals( p1, p2);  // Same coordinates
    }


    @Test
    void testEqualsCartesianPosition55() {
        Position p1 = new CartesianPosition(5, 5);
        Position p2 = new CartesianPosition( 5, 5);

        assertEquals( p1, p2);  // Same coordinates
    }


    @Test
    void testNotEqualsCartesianPositionIncNull() {
        Position p1 = new CartesianPosition(0, 0);
        Position p2 = new CartesianPosition( 1, 0);
        Position p3 = new CartesianPosition( 0, 1);

        assertNotEquals( p1, p2);
        assertNotEquals( p1, p3);
        assertNotEquals( p2, p3);
        assertNotEquals( p1, null);
    }


    @Test
    void testGetAdjacentPosition() {
        Position p1 = new CartesianPosition( 0, 0);

        Position pN = p1.getNeighbour(Rotator.Heading.NORTH);
        Position pE = p1.getNeighbour(Rotator.Heading.EAST);
        Position pS = p1.getNeighbour(Rotator.Heading.SOUTH);
        Position pW = p1.getNeighbour(Rotator.Heading.WEST);

        assertEquals(new CartesianPosition(0, 1), pN);
        assertEquals(new CartesianPosition(1, 0), pE);
        assertEquals(new CartesianPosition(0, -1), pS);
        assertEquals(new CartesianPosition(-1, 0), pW);
    }


    @Test
    void testToStringMethod() {
        Position p1 = new CartesianPosition( 0, 0);

        assertEquals("0 0", p1.toString());
        assertEquals("-1 -1", p1.getNeighbour(Rotator.Heading.SOUTH).getNeighbour(Rotator.Heading.WEST).toString());
    }

    @Test
    void testToStringMethodBigNumbers() {
        Position p1 = new CartesianPosition( 1000, 99999);

        assertEquals("1000 99999", p1.toString());
    }



    @Test
    void testLessOrEqual() {
        Position p1 = new CartesianPosition(0, 0);

        assertTrue (p1.lessOrEqual(p1));
        assertTrue (p1.lessOrEqual(new CartesianPosition(0,0)));
        // Go CW round the grid, starting N
        assertTrue (p1.lessOrEqual(new CartesianPosition(0,1)));
        assertTrue (p1.lessOrEqual(new CartesianPosition(1,1)));
        assertTrue (p1.lessOrEqual(new CartesianPosition(1,0)));
        assertFalse(p1.lessOrEqual(new CartesianPosition(1,-1)));
        assertFalse(p1.lessOrEqual(new CartesianPosition(0,-1)));
        assertFalse(p1.lessOrEqual(new CartesianPosition(-1,-1)));
        assertFalse(p1.lessOrEqual(new CartesianPosition(-1,0)));
        assertFalse(p1.lessOrEqual(new CartesianPosition(-1,1)));
    }




    @Test
    void testGreaterOrEqual() {
        Position p1 = new CartesianPosition(0, 0);
        assertTrue (p1.greaterOrEqual(p1));
        assertTrue (p1.greaterOrEqual(new CartesianPosition(0,0)));
        // Go CW round the grid, starting N
        assertFalse(p1.greaterOrEqual(new CartesianPosition(0,1)));
        assertFalse(p1.greaterOrEqual(new CartesianPosition(1,1)));
        assertFalse(p1.greaterOrEqual(new CartesianPosition(1,0)));
        assertFalse(p1.greaterOrEqual(new CartesianPosition(1,-1)));

        assertTrue (p1.greaterOrEqual(new CartesianPosition(0,-1)));
        assertTrue (p1.greaterOrEqual(new CartesianPosition(-1,-1)));
        assertTrue (p1.greaterOrEqual(new CartesianPosition(-1,0)));
        assertFalse(p1.greaterOrEqual(new CartesianPosition(-1,1)));
    }

}