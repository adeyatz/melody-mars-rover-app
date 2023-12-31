package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;

public class VehicleManager implements ICheckPosition {
    private ArrayList<Vehicle> vehicles;

    public VehicleManager () {
        vehicles = new ArrayList<Vehicle>();
      }

    public void addVehicle (Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public boolean removeVehicle (Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }

    public int getVehicleCount() {
        return vehicles.size();
    }

    public Vehicle getVehicle (Position position) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPosition().equals(position))
                return vehicle;
        }

        return null;
    }


    @Override
    public boolean canUsePosition(Position position) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPosition().equals(position))
                return false;
        }

        return true;
    }
}
