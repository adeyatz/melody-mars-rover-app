package org.melody.roverApp;
import org.melody.rover.*;
import org.melody.rover.api.Vehicle;

public class MarsRoverApp {

    MarsRoverManager mRManager;

    public MarsRoverApp() {
        mRManager = new MarsRoverManager();
    }

    public void Run() {
//        IStringReader inputReader = new DummyStringReader();
        IStringReader inputReader = new FileStringReader();

        String[] input = inputReader.read();

        if (input.length > 3) {
            initialisePlateau(input[0].trim());

            for (int i = 1; i < input.length; i += 2) {
                runRover(input[i].trim(), input[i + 1].trim());
            }
        }
    }


    private void initialisePlateau(String plateau) {
        // NO SYNTAX CHECKING !!!!!
        String[] input = plateau.split(" ");
        mRManager.createPlateau(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]));
    }


    private void runRover(String create, String move) {
        // NO SYNTAX CHECKING !!!!!
        String[] input = create.split(" ");

        Vehicle rover = mRManager.createMarsRover(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]),
                input[2]);

        String result = mRManager.moveMarsRover(rover, move);
        System.out.println(result);
    }


}
