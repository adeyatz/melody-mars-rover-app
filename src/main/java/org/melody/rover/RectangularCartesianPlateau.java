package org.melody.rover;

import org.melody.rover.api.IPlateauBoundary;
import org.melody.rover.api.Position;

import java.security.InvalidParameterException;

public class RectangularCartesianPlateau implements IPlateauBoundary {

    int lowerLeftX, lowerLeftY, upperRightX, upperRightY;

    public RectangularCartesianPlateau(int width, int height) throws IllegalArgumentException {
        if ((width <= 0) || (height <= 0))
            throw new IllegalArgumentException ("Width and Height must be greater than 0");

        lowerLeftX = lowerLeftY = 0;
        upperRightX = width;
        upperRightY = height;
    }

    @Override
    public boolean isPositionInPlateauBoundary(Position position) {
        if (position instanceof CartesianPosition) {

        }
        return false;
    }
}
