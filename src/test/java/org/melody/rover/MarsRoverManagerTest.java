package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.melody.rover.api.Vehicle;

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

        // Now try to add a second rover where the first rover is located - should fail with exception
        try {
            mrm.createMarsRover(x, y, "W");
            fail("Atttempt to create a Rover in an occupied location should fail");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
            assertEquals(1, mrm.getVehicleManager().getVehicleCount());
        }
    }


    @Test
    public void testCreateMarsRoverBeforePlateau() {
        MarsRoverManager mrm = new MarsRoverManager();
        int width = 10, height = 20;

        try {
            mrm.createMarsRover(1, 1, "E");
            fail("Creation of rover prior to plateua should cause exception");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testCreateMarsRoverOutsidePlateau() {
        MarsRoverManager mrm = new MarsRoverManager();
        int width = 10, height = 20;

        mrm.createPlateau(10, 10);

        try {
            mrm.createMarsRover(11, 11, "E");
            fail("Should not be able to create Mars rover outside of the plateau");
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testMoveMarsRoverMethod() {
        MarsRoverManager mrm = new MarsRoverManager();
        mrm.createPlateau (5, 5);

        Vehicle rover = mrm.createMarsRover (1,2,"N");
        assertNotNull(rover);

        String moveInstructions = "LMLMLMLMM";
        String expectedResult = "1 3 N";
        assertEquals(expectedResult, mrm.moveMarsRover (rover, moveInstructions));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/MoverTest.csv")
    void testMarsRoverManager (String startPosition, String moveInstructions, String expectedResult) {
        String[] stPos = startPosition.split(" ");
        assertEquals(3, stPos.length);
        assertTrue(stPos[2].matches("[NSEW]"));

        MarsRoverManager mrm = new MarsRoverManager();

        mrm.createPlateau(5,5);

        Vehicle vehicle = mrm.createMarsRover(Integer.parseInt(stPos[0]),
                                             Integer.parseInt(stPos[1]),
                                                stPos[2]);

        mrm.moveMarsRover(vehicle, moveInstructions);
        assertEquals(expectedResult, vehicle.printPostion());
    }


}