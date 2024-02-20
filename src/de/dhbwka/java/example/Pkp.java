package de.dhbwka.java.example;

import java.util.ArrayList;
import java.util.List;

public class Pkp {
    public static void main(String[] args) {
        List<Toupel> toupels = new ArrayList<>();
        toupels.add(new Toupel("0","52"));
        toupels.add(new Toupel("2","0"));
        toupels.add(new Toupel("2505","25"));
        toupels.add(new Toupel("3","23"));
        System.out.println(searchProblem(toupels).toString());
    }

    public static List<Toupel> searchProblem(List<Toupel> toupels){
        for (int length = 1; length <= 4; length++) {
            for (int toupel1 = 0; toupel1 < toupels.size(); toupel1++) {
                for (int toupel2 = 0; toupel2 < toupels.size(); toupel2++) {
                    for (int toupel3 = 0; toupel3 < toupels.size(); toupel3++) {
                        for (int toupel4 = 0; toupel4 < toupels.size(); toupel4++) {
                            for (int toupel5 = 0; toupel5 < toupels.size(); toupel5++) {


                                List<Toupel> order = new ArrayList<>();
                                switch (length) {
                                    case 5:
                                        order.add(toupels.get(toupel5));
                                    case 4:
                                        order.add(toupels.get(toupel4));
                                    case 3:
                                        order.add(toupels.get(toupel3));
                                    case 2:
                                        order.add(toupels.get(toupel2));
                                    case 1:
                                        order.add(toupels.get(toupel1));
                                }
                                StringBuilder option1 = new StringBuilder();
                                StringBuilder option2 = new StringBuilder();
                                order.forEach(t -> {
                                    option1.append(t.getOption(0));
                                    option2.append(t.getOption(1));
                                });
                                if (option1.toString().equals(option2.toString())) {
                                    return order;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    private static class Toupel{
        private String[] options;
        public Toupel(String first, String second){
            options = new String[]{first,second};
        }

        public String getOption(int index) {
            return options[index];
        }
    }
}
