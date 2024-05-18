package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextfileViewer {
    public TextfileViewer() {
        JFileChooser fileChooser = new JFileChooser();
        setFileFilter(fileChooser);
        fileChooser.showOpenDialog(null);
        try {
            new TextFrame("bla", 400, 400, String.join(System.lineSeparator(), Files.readAllLines(Path.of(fileChooser.getSelectedFile().getAbsolutePath()))));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setFileFilter(JFileChooser fileChooser) {
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return "Text Files";
            }
        });
    }

    public static void main(String[] args) {
        new TextfileViewer();
    }
}