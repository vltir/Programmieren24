package de.dhbwka.java.exercise.threads.buffer;

import java.util.Random;

public class ConsumerThread extends Thread{
    final MyBuffer<Integer> buffer;
    Random random = new Random();

    public ConsumerThread(MyBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            consume();
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void consume(){
        if(!buffer.isEmpty()){
            System.out.println("consumed "+buffer.pull());
            return;
        }
        System.out.println("Buffer is empty cannot consume!");

    }
}
