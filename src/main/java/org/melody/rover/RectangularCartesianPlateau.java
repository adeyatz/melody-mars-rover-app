package org.melody.rover;

import org.melody.rover.api.IPlateauBoundary;
import org.melody.rover.api.Position;

public class RectangularCartesianPlateau implements IPlateauBoundary {

    int lowerLeftX, lowerLeftY, upperRightX, upperRightY;

    public RectangularCartesianPlateau(int width, int height) {
        lowerLeftX = lowerLeftY = 0;
        upperRightX = width;
        upperRightY = height;
    }

    @Override
    public boolean isPositionInPlateauBoundary(Position position) {

        return false;
    }
}
