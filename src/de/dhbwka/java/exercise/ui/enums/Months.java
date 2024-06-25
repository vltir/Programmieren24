package de.dhbwka.java.exercise.ui.enums;

import java.util.Calendar;
import java.util.List;

public enum Months {

    JANUAR(31, List.of("Hartung", "Eismond")),
    FEBRUAR(28, List.of("Hornung", "Schmelzmond", "Taumond", "Narrenmond", "Rebmond", "Hintester")),
    MAERZ(31, List.of("Lenzing", "Lenzmond")),
    APRIL(30, List.of("Launing", "Ostermond")),
    MAI(31, List.of("Winnemond", "Blumenmond")),
    JUNI(30, List.of("Brachet", "Brachmond")),
    JULI(31, List.of("Heuert", "Heumond")),
    AUGUST(31, List.of("Ernting", "Erntemond", "Bisemond")),
    SEPTEMBER(30, List.of("Scheiding", "Herbstmond")),
    OKTOBER(31, List.of("Gilbhart", "Gilbhard", "Weinmond")),
    NOVEMBER(30, List.of("Nebelung", "Windmond", "Wintermond")),
    DEZEMBER(31, List.of("Julmond", "Heilmond", "Christmond", "Dustermond"));
    public final int days;
    public final List<String>altNamen;
    Months(int days, List<String>altNamen) {
        this.days=days;
        this.altNamen = altNamen;
    }

    public static void main(String[] args) {
        int monthNum=Calendar.getInstance().get(Calendar.MONTH);
        Months aktuellerMonat = Months.values()[monthNum];
        String alteNamenString = String.join(", ", aktuellerMonat.altNamen);
        System.out.printf("Der aktuelle Monat heißt %s. Früher hatte er die Namen: %s%n", aktuellerMonat, alteNamenString);
    }
}
