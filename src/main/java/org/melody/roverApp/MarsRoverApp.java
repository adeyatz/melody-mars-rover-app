package org.melody.roverApp;
import org.melody.rover.*;
import org.melody.rover.api.Vehicle;

public class MarsRoverApp {

    MarsMissionController missionController;

    public MarsRoverApp() {
        missionController = new MarsMissionController();
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
        missionController.createPlateau(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]));
    }


    private void runRover(String create, String move) {
        // NO SYNTAX CHECKING !!!!!
        String[] input = create.split(" ");

        Vehicle rover = missionController.createMarsRover(Integer.parseInt(input[0]),
                Integer.parseInt(input[1]),
                input[2]);

        String result = missionController.moveMarsRover(rover, move);
        System.out.println(result);
    }


}
