package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.melody.rover.api.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class MarsMissionControllerTest {

    @Test
    public void testMarsRoverManagerConstructor() {
        MarsMissionController mmc = new MarsMissionController();
        assertNotNull (mmc);
    }

    @Test
    public void testCreatePlateauMethod() {


    }


    @Test
    public void testCreateRoverBeforePlateauCausesError() {
        MarsMissionController mmc = new MarsMissionController();
        try {
            mmc.createMarsRover(1, 1, "E");
            fail("Should fail if a Vehicle is created before the Plateau");
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Test
    public void testCreateMarsRoverMethod() {
        MarsMissionController mmc = new MarsMissionController();
        int width = 10, height = 20;
        mmc.createPlateau (width, height);

        int x = 1, y = 1;
        mmc.createMarsRover (x,y,"E");

        assertEquals(1, mmc.getVehicleManager().getVehicleCount());

        // Now try to add a second rover where the first rover is located - should fail with exception
        try {
            mmc.createMarsRover(x, y, "W");
            fail("Atttempt to create a Rover in an occupied location should fail");
        } catch (MarsRoverException e) {
            System.out.println(e);
            assertEquals(1, mmc.getVehicleManager().getVehicleCount());
        }
    }


    @Test
    public void testCreateMarsRoverBeforePlateau() {
        MarsMissionController mmc = new MarsMissionController();
        int width = 10, height = 20;

        try {
            mmc.createMarsRover(1, 1, "E");
            fail("Creation of rover prior to plateua should cause exception");
        } catch (MarsRoverException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testCreateMarsRoverOutsidePlateau() {
        MarsMissionController mmc = new MarsMissionController();
        int width = 10, height = 20;

        mmc.createPlateau(10, 10);

        try {
            mmc.createMarsRover(11, 11, "E");
            fail("Should not be able to create Mars rover outside of the plateau");
        } catch (MarsRoverException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testMoveMarsRoverMethod() {
        MarsMissionController mmc = new MarsMissionController();
        mmc.createPlateau (5, 5);

        Vehicle rover = mmc.createMarsRover (1,2,"N");
        assertNotNull(rover);

        String moveInstructions = "LMLMLMLMM";
        String expectedResult = "1 3 N";
        mmc.moveMarsRover (rover, moveInstructions);
        assertEquals(expectedResult, rover.toString());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/MoverTest.csv")
    void testMarsRoverManager (String startPosition, String moveInstructions, String expectedResult) {
        String[] stPos = startPosition.split(" ");
        assertEquals(3, stPos.length);
        assertTrue(stPos[2].matches("[NSEW]"));

        MarsMissionController mmc = new MarsMissionController();

        mmc.createPlateau(5,5);

        Vehicle vehicle = mmc.createMarsRover(Integer.parseInt(stPos[0]),
                                             Integer.parseInt(stPos[1]),
                                                stPos[2]);

        mmc.moveMarsRover(vehicle, moveInstructions);
        assertEquals(expectedResult, vehicle.toString());
    }


}