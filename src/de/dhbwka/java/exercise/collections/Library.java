package de.dhbwka.java.exercise.collections;

import javax.swing.*;
import java.util.List;

public class Library {
    JFrame frame;
    JPanel panel;
    JTextField title;
    JTextField author;
    JTextField year;
    JTextField publisher;
    public Library() {
        frame= new JFrame();
        frame.setTitle("Library");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel=new JPanel();
        title=new JTextField(32);
        author=new JTextField(32);
        year=new JTextField(32);
        publisher=new JTextField(32);
        List<JComponent> components = List.of(new JLabel("Title"),title,new JLabel("Author"),author,new JLabel("Year"),year,new JLabel("Publisher"),publisher);
        components.forEach(panel::add);



        frame.setVisible(true);

    }
}
