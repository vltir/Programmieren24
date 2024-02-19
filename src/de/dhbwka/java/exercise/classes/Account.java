package de.dhbwka.java.exercise.classes;

public class Account {
    long kontoNummer;
    String inhaber;

    int kontoStand;

    int limit;

    public static void main(String[] args) {
        Account account = new Account(4711, "Donald Duck", 500, 1000);
        System.out.println(account);
        account.einzahlen(200);
        System.out.println(account);
        account.auszahlen(400);
        System.out.println(account);
        account.auszahlen(2000);
        System.out.println(account);
    }

    public Account(long kontoNummer, String inhaber, int kontoStand, int limit) {
        this.kontoNummer = kontoNummer;
        this.inhaber = inhaber;
        this.kontoStand = kontoStand;
        this.limit = -limit;
    }

    public Account(long kontoNummer, String inhaber, int kontoStand) {
        this(kontoNummer, inhaber, kontoStand, -100000);
    }

    public Account(long kontoNummer, String inhaber) {
        this(kontoNummer, inhaber, 0);
    }

    public int getKontoStand() {
        return kontoStand;
    }

    public void einzahlen(int einzahlung) {
        if (einzahlung <= 0) throw new IllegalArgumentException("nur positive Beträge können eingezahlt werden");
        this.kontoStand += einzahlung;
    }

    public void auszahlen(int auszahlung) {
        if (auszahlung <= 0) throw new IllegalArgumentException("nur positive Beträge können ausgezahlt werden");
        if(kontoStand-auszahlung<limit){
            System.err.println("Limit Überschreitung. Transaktion wurde nicht durchgeführt.");
            return;
        }
        this.kontoStand -= auszahlung;
    }

    @Override
    public String toString() {
        return "Account{" +
                "kontoNummer=" + kontoNummer +
                ", inhaber='" + inhaber + '\'' +
                ", kontoStand=" + kontoStand +
                ", limit=" + limit +
                '}';
    }
}
