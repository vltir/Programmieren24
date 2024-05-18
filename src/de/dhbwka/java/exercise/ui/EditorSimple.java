package de.dhbwka.java.exercise.ui;

import javax.swing.*;

public class EditorSimple {
    JFrame frame;
    public EditorSimple() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setJMenuBar(initMenuBar(new JMenuBar()));
        frame.setVisible(true);
    }

    private JMenuBar initMenuBar(JMenuBar menuBar) {
        //file menu
        JMenu file = new JMenu("Datei");
        file.add(new JMenuItem("Neu"));
        file.add(new JMenuItem("Öffnen"));
        file.add(new JSeparator());
        file.add(new JMenuItem("Schließen"));
        file.add(new JSeparator());
        file.add(new JMenuItem("Speichern"));
        file.add(new JMenuItem("Speichern unter ..."));
        file.add(new JMenuItem("Als Webseite speichern"));
        file.add(new JMenuItem("Suchen"));
        file.add(new JSeparator());
        file.add(new JMenuItem("Versionen"));
        file.add(new JSeparator());
        file.add(new JMenuItem("Webseitenvorschau"));
        file.add(new JSeparator());
        file.add(new JMenuItem("Seite einrichten ..."));
        file.add(new JMenuItem("Seitenansicht"));
        file.add(new JMenuItem("Drucken"));
        file.add(new JSeparator());
        JMenu sendMenu = new JMenu("Senden an");
        sendMenu.add(new JMenuItem("E-Mail-Empfänger"));
        sendMenu.add(new JMenuItem("E-Mail-Empfänger (zur Überarbeitung)"));
        sendMenu.add(new JMenuItem("E-Mail-Empfänger (als Anlage)"));
        sendMenu.add(new JSeparator());
        sendMenu.add(new JMenuItem("Verteilerempfänger ..."));
        sendMenu.add(new JMenuItem("Onlinebesprechungsteilnehmer"));
        sendMenu.add(new JMenuItem("Exchange-Ordner ..."));
        sendMenu.add(new JMenuItem("Fax-Empfänger ..."));
        sendMenu.add(new JSeparator());
        sendMenu.add(new JMenuItem("Microsoft PowerPoint"));
        file.add(sendMenu);
        file.add(new JMenuItem("Eigenschaften"));
        file.add(new JSeparator());
        file.add(new JMenuItem("bilanz_2017.doc"));
        file.add(new JMenuItem("bericht_2018_01.doc"));
        file.add(new JMenuItem("ziele.doc"));
        file.add(new JSeparator());
        file.add(new JMenuItem("Beenden"));
        menuBar.add(file);
        //edit menu
        JMenu edit = new JMenu("Bearbeiten");
        edit.add(new JMenuItem("Rückgängig"));
        edit.add(new JMenuItem("Wiederholen"));
        edit.add(new JSeparator());
        edit.add(new JMenuItem("Ausschneiden"));
        edit.add(new JMenuItem("Kopieren"));
        edit.add(new JMenuItem("Office-Zwischenablage"));
        edit.add(new JMenuItem("Einfügen"));
        edit.add(new JMenuItem("Inhlate einfügen"));
        edit.add(new JMenuItem("Inhlate einfügen"));
        edit.add(new JMenuItem("Als Hyperlink einfügen"));
        edit.add(new JSeparator());
        edit.add(new JMenuItem("Löschen"));
        edit.add(new JMenuItem("Alles markieren"));
        edit.add(new JSeparator());
        edit.add(new JMenuItem("Suchen ..."));
        edit.add(new JMenuItem("Ersetzen ..."));
        edit.add(new JMenuItem("Gehen zu ..."));
        edit.add(new JSeparator());
        edit.add(new JMenuItem("Verknüpfungen ..."));
        edit.add(new JMenuItem("Objekt"));
        menuBar.add(edit);
        return menuBar;
    }

    public static void main(String[] args) {
        new EditorSimple();
    }
}
