package org.melody.roverApp;
import org.melody.rover.*;
import org.melody.rover.api.Vehicle;

public class MarsRoverApp {

    MarsRoverManager mRManager;

    public MarsRoverApp() {
        mRManager = new MarsRoverManager();
    }

    public void Run() {
        IStringReader inputReader = new TestStringReader();

        String[] input = inputReader.read();

        if (input.length > 3) {
            parsePlateauParameters(input[0]);

            for (int i = 1; i < input.length; i += 2) {
                parseCreateAndMove(input[i], input[i + 1]);
            }
        }
    }


    private void parsePlateauParameters(String plateau) {
        // NO SYNTAX CHECKING !!!!!
        String[] input = plateau.split(" ");
        mRManager.createPlateau(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]));
    }


    private void parseCreateAndMove(String create, String move) {
        // NO SYNTAX CHECKING !!!!!
        String[] input = create.split(" ");

        Vehicle rover = mRManager.createMarsRover(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]),
                input[2]);

        System.out.println(mRManager.moveMarsRover(rover, move));
    }


}
