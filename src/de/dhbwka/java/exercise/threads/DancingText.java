package de.dhbwka.java.exercise.threads;

import de.dhbwka.java.util.swing.builders.JFrameBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class DancingText {
    private static double rotation = 0.0;
    private static List<String> letters;
    private static JPanel panel;
    public static void main(String[] args) {
        String input ="Dancing Text :-)";
        letters = Arrays.asList(input.split(""));
        panel = new PaintPanel(DancingText::draw);
        new JFrameBuilder().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE).setTitle("Dancing Text").setSize(800,800).add(panel, BorderLayout.CENTER).setVisible(true).build();
        Thread thread = new Thread(DancingText::run);
        thread.start();
    }
    public static void run(){
        while (true) {
            rotation += 0.1;
            if (rotation >= 2 * Math.PI) rotation = 0;
            panel.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void draw(Graphics g){
        g.setFont(new Font("Arial", Font.BOLD, 60));
        for (int i = 0; i < letters.size(); i++) {
            int red = (int) (127.5 * Math.sin(rotation+i+2.0/3.0*Math.PI))+128;
            int green = (int) (127.5 * Math.sin(rotation+i+4.0/3.0*Math.PI))+128;
            int blue = (int) (127.5 * Math.sin(rotation+i))+128;
            g.setColor(new Color(red,green,blue));
            g.drawString(letters.get(i),10+i*50, (int) (200+Math.sin(rotation+i)*100));
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
