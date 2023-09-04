package org.melody.rover;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartesianPositionTest {

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

        Position pN = p1.getAdjacent(Position.Adjacent.N);
        Position pNE = p1.getAdjacent(Position.Adjacent.NE);
        Position pE = p1.getAdjacent(Position.Adjacent.E);
        Position pSE = p1.getAdjacent(Position.Adjacent.SE);
        Position pS = p1.getAdjacent(Position.Adjacent.S);
        Position pSW = p1.getAdjacent(Position.Adjacent.SW);
        Position pW = p1.getAdjacent(Position.Adjacent.W);
        Position pNW = p1.getAdjacent(Position.Adjacent.NW);

        assertEquals(new CartesianPosition(0, 1), pN);
        assertEquals(new CartesianPosition(1, 1), pNE);
        assertEquals(new CartesianPosition(1, 0), pE);
        assertEquals(new CartesianPosition(1, -1), pSE);
        assertEquals(new CartesianPosition(0, -1), pS);
        assertEquals(new CartesianPosition(-1, -1), pSW);
        assertEquals(new CartesianPosition(-1, 0), pW);
        assertEquals(new CartesianPosition(-1, 1), pNW);

    }


    @Test
    void testToStringMethod() {
        Position p1 = new CartesianPosition( 0, 0);

        assertEquals("0 0", p1.toString());
        assertEquals("-1 -1", p1.getAdjacent(Position.Adjacent.SW).toString());
    }

    @Test
    void testToStringMethodBigNumbers() {
        Position p1 = new CartesianPosition( 1000, 99999);

        assertEquals("1000 99999", p1.toString());
    }


    @Test
    void compareTo() {
    }


}