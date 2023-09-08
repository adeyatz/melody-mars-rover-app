package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Plateau;
import org.melody.rover.api.Position;

public class RectangularCartesianPlateau extends Plateau {

    Position ll, ur = null;
    private static final String Type = "Rectangular Cartesian";

    public RectangularCartesianPlateau(int width, int height) throws IllegalArgumentException {
        if ((width <= 0) || (height <= 0))
            throw new IllegalArgumentException ("Width and Height must be greater than 0");

        ll = new CartesianPosition(0,0);
        ur = new CartesianPosition(width, height);
    }

    @Override
    public boolean canUsePosition(Position position) {
        if (position instanceof CartesianPosition) {
            return (ll.greaterOrEqual(position) && (ur.lessOrEqual(position)));
        }
        return false;
    }

    @Override
    protected String getType() {
        return Type;
    }
}
