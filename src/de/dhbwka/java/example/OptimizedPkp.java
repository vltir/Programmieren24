package de.dhbwka.java.example;

import java.util.Arrays;
import java.util.List;

public class OptimizedPkp {
    public static void main(String[] args) {
        List<Tupel> tupels = List.of(new Tupel("2505","25"), new Tupel("2","0"), new Tupel("0","52"), new Tupel("2","0"), new Tupel("3","23"));


    }

    public static void findProblem(List<Tupel> tupels){
        String[] overhead = new String[]{"",""};
        if(overhead[0].length()==overhead[1].length()){
            for (Tupel tupel : tupels) {
                String[]newOverheads= Arrays.copyOf(overhead,2);
                for (int i = 0; i < newOverheads.length; i++) {
                    newOverheads[i]=tupel.options[i];
                }
            }
        }
    }

    public static class Tupel{
        String[] options;
        public Tupel(String first, String second){
            options = new String[]{first,second};
        }
    }
}
