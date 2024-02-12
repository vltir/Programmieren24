package de.dhbwka.java.exercise.classes;

public class Radio {

    public static void main(String[] args) {
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        radio.turnOn();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.incVolume();
        radio.incVolume();
        System.out.println(radio);
        radio.decVolume();
        System.out.println(radio);
        radio.setFrequency(97.8);
        System.out.println(radio);
        radio.setFrequency(112.7);
        System.out.println(radio);
        radio.turnOff();
        System.out.println(radio);
    }

    private boolean on;
    private int volume;
    private double frequency;

    Radio(boolean on, int volume, double frequency) {
        if (volume < 0 || volume > 10) throw new IllegalArgumentException("Volume must be in range of 0 - 10.");
        this.on = on;
        this.volume = volume;
        setFrequency(frequency);
    }

    Radio() {
        this(false, 0, 0.0);
    }

    void incVolume() {
        if (!on || volume >= 10) return;
        volume++;
    }

    void decVolume() {
        if (!on || volume <= 0) return;
        volume--;
    }

    void turnOn() {
        on = true;
    }

    void turnOff() {
        on = false;
    }

    void setFrequency(double frequency) {
        if (frequency < 85.0 || frequency > 110.0) {
            this.frequency = 99.9;
            return;
        }
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return String.format("radio %s :Freq=%.1f, Laut=%d", on ? "an" : "aus", frequency, volume);
    }
}
