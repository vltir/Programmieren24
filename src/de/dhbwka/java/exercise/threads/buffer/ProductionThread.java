package de.dhbwka.java.exercise.threads.buffer;

import java.util.Random;

public class ProductionThread extends Thread{
    final MyBuffer<Integer> buffer;
    Random random = new Random();

    public ProductionThread(MyBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            produce();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void produce(){
        if(!buffer.isFull()){
            int product = random.nextInt();
            buffer.push(product);
            System.out.println("produced "+product);
            return;
        }
        System.out.println("Buffer is full cannot produce!");
    }
}
