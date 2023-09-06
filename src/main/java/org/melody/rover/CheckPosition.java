package org.melody.rover;

import org.melody.rover.api.ICheckPosition;
import org.melody.rover.api.Position;

import java.util.ArrayList;

public class CheckPosition {

    public static boolean check (ArrayList <ICheckPosition> positionCheckers, Position position) {
        for (ICheckPosition positionCheck : positionCheckers) {
            if (!positionCheck.canUsePosition(position)) {
                System.out.format("Position check failed: %s, position %s\n", positionCheck.getClass().toString(), position);
                return false;
            }
        }
        return true;
    }
}
