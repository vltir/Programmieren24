package de.dhbwka.java.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hannoi {
    static List<List<Integer>> board;

    public static void main(String[] args) {
        int height = 8;
        board = List.of(IntStream.rangeClosed(0, 8).boxed().collect(Collectors.toList()), new ArrayList<>(), new ArrayList<>());


    }

    public static void build(int from, int to, int height) {
        if (height <= 1) {
            board.get(to).add(board.get(from).removeFirst());
        }
    }


}
