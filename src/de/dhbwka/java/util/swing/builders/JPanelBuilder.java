package de.dhbwka.java.util.swing.builders;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import javax.swing.border.Border;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class JPanelBuilder {
    private JPanel panel;
    private List<Component> components = new ArrayList<>();

    public JPanelBuilder() {
        this.panel = new JPanel();
    }

    public JPanelBuilder setSize(int width, int height) {
        this.panel.setSize(width, height);
        return this;
    }

    public JPanelBuilder setPreferredSize(Dimension dimension) {
        this.panel.setPreferredSize(dimension);
        return this;
    }

    public JPanelBuilder setBackground(Color color) {
        this.panel.setBackground(color);
        return this;
    }

    public JPanelBuilder setForeground(Color color) {
        this.panel.setForeground(color);
        return this;
    }

    public JPanelBuilder setFont(Font font) {
        this.panel.setFont(font);
        return this;
    }

    public JPanelBuilder setLayout(LayoutManager layout) {
        this.panel.setLayout(layout);
        return this;
    }

    public JPanelBuilder setBorder(Border border) {
        this.panel.setBorder(border);
        return this;
    }

    public JPanelBuilder add(Component component) {
        this.components.add(component);
        return this;
    }

    public JPanel build() {
        for (Component component : this.components) {
            this.panel.add(component);
        }
        return this.panel;
    }
}
