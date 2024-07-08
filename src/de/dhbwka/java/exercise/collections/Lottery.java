package de.dhbwka.java.exercise.collections;

import java.util.*;

public class Lottery {
    public Lottery() {
        ExclusiveRandom random = new ExclusiveRandom();
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
    private static class ExclusiveRandom extends Random{
        private static HashSet<Integer> pulled= new HashSet<>();
        @Override
        public int nextInt(int bound){
            if(pulled.size()>=bound)throw new RuntimeException("Cannot pull another random Number");
            int randomInt;
            do{
                randomInt = super.nextInt(bound);
            }while (pulled.contains(randomInt));
            pulled.add(randomInt);
            return randomInt;
        }
    }

}
