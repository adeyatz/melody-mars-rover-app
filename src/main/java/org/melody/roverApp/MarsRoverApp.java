package org.melody.roverApp;
import org.melody.rover.*;
import org.melody.rover.api.Vehicle;
import org.melody.roverIO.FileStringReader;
import org.melody.roverIO.IStringReader;

public class MarsRoverApp {

    private static final String FILE_NAME = "src/main/resources/MarsRoverInput.txt";
    MarsMissionController missionController;

    public MarsRoverApp() {
        missionController = new MarsMissionController();
    }


    public static void main (String[] args)
    {
        String filename = args.length > 0 ? args[0] : FILE_NAME;

        new MarsRoverApp().run(filename);
    }

    void run(String filename) {
//        IStringReader inputReader = new DummyStringReader();
        IStringReader inputReader = new FileStringReader(filename);

        String[] input = inputReader.read();

        if (input == null)
            return;

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

        missionController.moveMarsRover(rover, move);

        System.out.println(rover);
    }


}
