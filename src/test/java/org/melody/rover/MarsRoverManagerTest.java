package org.melody.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MarsRoverManagerTest {

    @Test
    public void testMarsRoverManagerConstructor() {
        MarsRoverManager mrm = new MarsRoverManager();
        assertNotNull (mrm);
    }

    @Test
    public void testCreatePlateauMethod() {


    }


    @Test
    public void testCreateRoverBeforePlateauCausesError() {
        MarsRoverManager mrm = new MarsRoverManager();
        try {
            mrm.createMarsRover(1, 1, "E");
            fail("Should fail if a Vehicle is created before the Plateau");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Test
    public void testCreateMarsRoverMethod() {
        MarsRoverManager mrm = new MarsRoverManager();
        int width = 10, height = 20;
        mrm.createPlateau (width, height);

        int x = 1, y = 1;
        mrm.createMarsRover (x,y,"E");


    }


    @Test
    public void testMoveMarsRoverMethod() {

    }

}