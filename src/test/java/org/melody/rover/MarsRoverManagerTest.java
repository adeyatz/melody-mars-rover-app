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

        assertEquals(1, mrm.getVehicleManager().getVehicleCount());

        // Now try to add a second rover where the first rover is located - should fail
        assertFalse (mrm.createMarsRover (x,y,"W"));
        assertEquals(1, mrm.getVehicleManager().getVehicleCount());
    }


    @Test
    public void testMoveMarsRoverMethod() {
        MarsRoverManager mrm = new MarsRoverManager();
        mrm.createPlateau (5, 5);

        assertTrue (mrm.createMarsRover (1,2,"N"));

        String moveInstructions = "LMLMLMLMM";
        String expectedResult = "1 3 N";
        assertEquals(expectedResult, mrm.moveMarsRover (moveInstructions));
    }

}