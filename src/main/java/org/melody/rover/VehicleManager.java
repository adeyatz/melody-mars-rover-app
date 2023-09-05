package org.melody.rover;

import org.melody.rover.api.IBlocked;
import org.melody.rover.api.IPlateau;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import java.util.ArrayList;

public class VehicleManager implements IBlocked {
    private ArrayList<Vehicle> vehicles;
    private Vehicle currentVehicle;

    public VehicleManager () {
        vehicles = new ArrayList<Vehicle>();
        currentVehicle = null;
    }

    public void addVehicle (Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public void removeVehicle (Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public int getVehicleCount() {
        return vehicles.size();
    }


    @Override
    public boolean isPositionBlocked(Position position) {

        return true;
    }
}
