package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;

public class Mover {
    ArrayList<ICheckPosition> positionCheckers;
    Vehicle vehicle;
    String moveInstructions;


    public Mover (ArrayList<ICheckPosition> positionCheckers, Vehicle vehicle, String moveInstructions) {
        this.positionCheckers = positionCheckers;
        this.vehicle = vehicle;
        this.moveInstructions = moveInstructions;
    }

    public void moveVehicle () {

        char[] instruction = moveInstructions.toCharArray();

        for (char c : instruction) {
            switch (c) {
                case 'L':
                    vehicle.rotateLeft();
                    break;

                case 'R':
                    vehicle.rotateRight();
                    break;

                case 'M':
                    // Next position
                    Position next = vehicle.getPosition().getNeighbour(vehicle.getRotation().getHeading());

                    // Check position clear
                    if (CheckPosition.check(positionCheckers, next)) {
                        vehicle.move(next);
                    }
                    else {
                        // Throw exception?
                    }
                default:
                    break;
            }
        }
    }
}
