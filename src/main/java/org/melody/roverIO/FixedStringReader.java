package org.melody.roverIO;

import org.melody.roverIO.IStringReader;

public class FixedStringReader implements IStringReader {

    static final String [] testInput = {"5 5", "1 2 N","LMLMLMLMM", "1 2 N", "MMRMMRMRRM"};    // Results should be 1 3 N, 3 2 N - first 2 moves of 2nd rover blocked by first rover

    // {"5 5", "5 5 N", "MRMLLMMM"};        // Results 2 5 W
    // {"5 5", "1 2 N","LMLMLMLMM", "3 3 E", "MMRMMRMRRM"};   // Results should be 1 3 N, 5 1 E

    @Override
    public String[] read() {
        return testInput;
    }
}
