package org.melody.rover;

import org.junit.jupiter.api.Test;
import org.melody.rover.api.IRotator;
import org.melody.rover.api.Position;
import org.melody.rover.api.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

class VehicleManagerTest {

    @Test
    void testVehicleManagerConstructor() {
        VehicleManager vm = new VehicleManager();

        assertNotNull(vm);
    }



    @Test
    void addVehicle() {
        VehicleManager vm = new VehicleManager();

        Position position = new CartesianPosition(10, 50);
        IRotator heading = new Compass(IRotator.Heading.WEST);
        Vehicle vehicle = new MarsRover (position, heading);
        vm.addVehicle(vehicle);

        assertEquals(1, vm.getVehicleCount());
    }

    @Test
    void removeVehicle() {
    }

    @Test
    void isPositionBlocked() {
    }
}