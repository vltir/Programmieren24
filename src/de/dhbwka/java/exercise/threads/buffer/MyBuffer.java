package de.dhbwka.java.exercise.threads.buffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyBuffer<T> {
    final int maxSize;
    List<T> content;

    public MyBuffer(int maxSize) {
        this.maxSize = maxSize;
        content = new LinkedList<>();
    }

    public synchronized T pull(){
        if(content.isEmpty())return null;
        return content.removeFirst();
    }
    public synchronized boolean push(T item){
        if(content.size()<maxSize){
            content.add(item);
            return true;
        }
        return false;
    }

    public synchronized int getSize(){
        return content.size();
    }

    public synchronized boolean isFull(){
        return content.size()>=maxSize;
    }

    public synchronized boolean isEmpty(){
        return content.isEmpty();
    }
}
