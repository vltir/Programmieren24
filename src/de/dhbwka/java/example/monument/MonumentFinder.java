package de.dhbwka.java.example.monument;

import java.util.*;

public class MonumentFinder {
    private static int MAX_DISTANCE =256;

    public static void main(String[] args) {
        Set<Position> positions = InputParser.parsePositions();
        System.out.println("Parsed Monuments:");
        System.out.println(positions.size());
        Set<Position.PositionTuple> closePairs = new HashSet<>();
        for (Position position : positions) {
            positions.stream().filter(p->(!p.equals(position))&&p.distance(position)<=MAX_DISTANCE).forEach(p->closePairs.add(new Position.PositionTuple(p,position)));
        }
        System.out.println("Number of Double Monuments:");
        System.out.println(closePairs.size());
        List<Position.PositionTuple> pairs = new ArrayList<>(closePairs.stream().toList());
        Collections.sort(pairs);
        System.out.println("Closest Double Monument:");
        System.out.println(pairs.getFirst());
        System.out.println("All Triple Monuments");
        for (Position.PositionTuple pair : pairs) {
            pairs.stream().filter(p->(!p.equals(pair))&&p.distance(pair)<=MAX_DISTANCE).forEach(p-> System.out.println(p+" - "+pair));
        }
        System.out.println("No other!");
    }
}
