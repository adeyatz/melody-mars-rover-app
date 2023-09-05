package org.melody.rover;

import org.melody.rover.api.IPlateau;
import org.melody.rover.api.Position;

public class RectangularCartesianPlateau implements IPlateau {

    Position ll, ur = null;

    public RectangularCartesianPlateau(int width, int height) throws IllegalArgumentException {
        if ((width <= 0) || (height <= 0))
            throw new IllegalArgumentException ("Width and Height must be greater than 0");

        ll = new CartesianPosition(0,0);
        ur = new CartesianPosition(width, height);
    }

    @Override
    public boolean isPositionInBoundary(Position position) {
        if (position instanceof CartesianPosition) {
            return ((ll.compareTo(position) >= 0) && (ur.compareTo(position) <= 0));
        }
        return false;
    }
}
