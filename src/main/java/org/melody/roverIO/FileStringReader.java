package org.melody.roverIO;

import org.melody.roverIO.IStringReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileStringReader implements IStringReader {

    private String filename;

    public FileStringReader(String filename) {
        this.filename = filename;
    }

    @Override
    public String[] read() {
        try {
            List<String> lines = new ArrayList<String>();
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (!line.startsWith("#") && (line.length() > 0))
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
