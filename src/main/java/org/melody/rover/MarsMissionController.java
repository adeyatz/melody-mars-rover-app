package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Plateau;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MarsMissionController {
    Plateau plateau;
    VehicleManager vm;
    ArrayList < ICheckPosition> positionCheckers;

    public MarsMissionController() {
        plateau = null;
        vm = new VehicleManager();
    }


    public void createPlateau(int width, int height) {
        plateau = new RectangularCartesianPlateau(width,height);
        positionCheckers = new ArrayList<>(List.of (plateau, vm));
    }


    public Vehicle createMarsRover(int x, int y, String heading) {
        if (plateau == null)
            throw new MarsRoverException ("Create Plateau before creating a Mars Rover");

        // First check that the position is free
        if (CheckPosition.check(positionCheckers, new CartesianPosition(x,y))) {
            Vehicle newMarsRover = new MarsRover(x, y, heading);
            vm.addVehicle(newMarsRover);
            return newMarsRover;
        }
        throw new MarsRoverException (String.format("Mars Rover must be located on the plateau in an empty cell:(%d, %d)",x,y));
    }

    public boolean moveMarsRover(Vehicle rover, String moveInstructions) {
        if (plateau == null)
            throw new MarsRoverException ("Create Plateau before creating a Mars Rover");

        Mover mover = new Mover(positionCheckers,rover,moveInstructions);

        return mover.moveVehicle();
    }

    public VehicleManager getVehicleManager() {
        return vm;
    }

}
