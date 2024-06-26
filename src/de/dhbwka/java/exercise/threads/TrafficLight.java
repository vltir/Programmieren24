package de.dhbwka.java.exercise.threads;

import de.dhbwka.java.util.swing.builders.JFrameBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.concurrent.CopyOnWriteArrayList;


public class TrafficLight {
    private static double phase = 0.0;
    private static JPanel panel;
    private static CopyOnWriteArrayList<Color> colors = new CopyOnWriteArrayList<>(List.of(Color.black, Color.black, Color.black));
    public static void main(String[] args) {
        panel = new PaintPanel(TrafficLight::draw);
        new JFrameBuilder().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE).setTitle("Dancing Text").setSize(800,800).add(panel, BorderLayout.CENTER).setVisible(true).build();
        Thread thread = new Thread(TrafficLight::run);
        thread.start();
    }
    public static void run(){
        while (true) {
            phase += 0.1;
            if (phase >= 100) phase = 0;
            if(phase>=0&&phase<40){
                colors.set(0,Color.black);
                colors.set(1,Color.black);
                colors.set(2,Color.green);
            } else if (phase>=40&&phase<50) {
                colors.set(0,Color.black);
                colors.set(1,Color.yellow);
                colors.set(2,Color.black);
            }else if (phase>=50&&phase<90) {
                colors.set(0,Color.red);
                colors.set(1,Color.black);
                colors.set(2,Color.black);
            }else {
                colors.set(0,Color.red);
                colors.set(1,Color.yellow);
                colors.set(2,Color.black);
            }
            panel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(20,20,100,300);
        for (int i = 0; i < 3; i++) {
            g.setColor(colors.get(i));
            g.fillOval(30,30+i*100,80,80);
        }
    }

    private static class PaintPanel extends JPanel{
        private final Consumer<Graphics>graphicsConsumer;

        public PaintPanel(Consumer<Graphics> graphicsConsumer) {
            this.graphicsConsumer = graphicsConsumer;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            graphicsConsumer.accept(g);
        }
    }
}
