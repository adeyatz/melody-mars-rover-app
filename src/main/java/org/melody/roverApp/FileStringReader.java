package org.melody.roverApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileStringReader implements IStringReader{

    private static final String FILE_NAME = "src/main/resources/MarsRoverInput.csv";
    @Override
    public String[] read()  {

        String firstLine;

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            do {
                firstLine = reader.readLine();
            } while ((firstLine != null) && firstLine.startsWith("#"));
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return firstLine.split(",");
    }
}
