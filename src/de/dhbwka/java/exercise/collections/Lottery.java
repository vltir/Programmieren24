package de.dhbwka.java.exercise.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {
    Random random = new Random();
    public Lottery() {
        int capacity = 7;
        List<Integer> nums = new ArrayList<>(capacity);
        for (int i = 0; i < capacity-1; i++) {
            nums.add(random.nextInt(49)+1);
        }
        Collections.sort(nums);
        nums.add(random.nextInt(49)+1);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < nums.size()-1; i++) {
            out.append(nums.get(i)).append(" ");
        }
        out.append("Zusatzzahl: ").append(nums.getLast());
        System.out.println(out);
    }

    public static void main(String[] args) {
        new Lottery();
    }

}
