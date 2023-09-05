package org.melody.rover;

import org.melody.rover.api.IPlateauBoundary;
import org.melody.rover.api.Position;

import java.security.InvalidParameterException;

public class RectangularCartesianPlateau implements IPlateauBoundary {

    Position ll, ur = null;

    public RectangularCartesianPlateau(int width, int height) throws IllegalArgumentException {
        if ((width <= 0) || (height <= 0))
            throw new IllegalArgumentException ("Width and Height must be greater than 0");

        ll = new CartesianPosition(0,0);
        ur = new CartesianPosition(width, height);
    }

    @Override
    public boolean isPositionInPlateauBoundary(Position position) {
        if (position instanceof CartesianPosition) {
            return ((ll.compareTo(position) >= 0) && (ur.compareTo(position) <= 0));
        }
        return false;
    }
}
