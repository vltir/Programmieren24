package de.dhbwka.java.exercise.ui.paint.election;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ElectionGrpahics extends JComponent {
    private List<Party>partys;
    public ElectionGrpahics(List<Party> partys) {
        this.partys=partys;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //barchart
        for (int i = 0; i < partys.size(); i++) {
            g.setColor(partys.get(i).color());
            g.fillRect(i*40+20,500-(int)partys.get(i).percentage()*10,30,(int)partys.get(i).percentage()*10);
            g.drawString(partys.get(i).name(),i*40+20,510);
            System.out.println((int)partys.get(i).percentage());
        }

        //piechart
        int pieX = 400;
        int pieY = 300;
        int pieWidth = 200;
        int pieHeight = 200;

        double totalVotes = partys.stream().mapToDouble(Party::percentage).sum();
        totalVotes*=2;

        double startAngle = 0;
        for (Party party : partys) {
            double slicePercentage = party.percentage() / totalVotes;
            double sweepAngle = slicePercentage * 360;

            g.setColor(party.color());
            g.fillArc(pieX, pieY, pieWidth, pieHeight, (int) startAngle, (int) sweepAngle);
            startAngle += sweepAngle;
        }

    }
}
