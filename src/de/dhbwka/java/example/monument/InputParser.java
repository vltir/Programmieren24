package de.dhbwka.java.example.monument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputParser {
    public static Set<Position> parsePositions(){
        Set<Position> positions = new HashSet<>();
        readInput("./src/de/dhbwka/java/example/monument/input.txt").stream().map(l->l.split(";")).forEach(a->positions.add(new Position(Integer.parseInt(a[2]),Integer.parseInt(a[3]))));
        return positions;
    }

    public static List<String> readInput(String path){
        try {
            return Files.readAllLines(Path.of(path));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
