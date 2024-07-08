package de.dhbwka.java.exercise.threads.buffer;

public class BufferTest {
    public static void main(String[] args) {
        MyBuffer<Integer> buffer = new MyBuffer<>(3);
        ConsumerThread consumerThread = new ConsumerThread(buffer);
        ProductionThread productionThread = new ProductionThread(buffer);
        productionThread.start();
        consumerThread.start();
    }
}
