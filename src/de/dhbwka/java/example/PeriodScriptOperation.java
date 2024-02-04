package de.dhbwka.java.example;

import java.util.Arrays;
import java.util.List;

public class PeriodScriptOperation {
    public static void main(String[] args) {
        List<String> inputLines = InputReader.readInput("./src/de/dhbwka/java/example/input.txt");
        String[] inputAr = inputLines.get(0).split("\u2029");
        System.out.println(Arrays.stream(inputAr).mapToInt(l->Integer.parseInt(l.split("» ")[2].split("gt")[0])).map(n->n/8).average().orElse(-1));
    }
}
