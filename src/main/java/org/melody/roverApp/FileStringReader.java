package org.melody.roverApp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStringReader implements IStringReader{

    private static final String FILE_NAME = "src/main/resources/MarsRoverInput.txt";
    @Override
    public String[] read() {
        try {
            List<String> lines = new ArrayList<String>();
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#"))
                    lines.add(line);
            }
            bufferedReader.close();
            return lines.toArray(new String[lines.size()]);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
