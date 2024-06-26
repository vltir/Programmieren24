package de.dhbwka.java.util.swing.builders;

import javax.swing.JFrame;
import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

public class JFrameBuilder {
    private String title = "";
    private int width = 800;
    private int height = 600;
    private boolean resizable = true;
    private LayoutManager layout = null;
    private WindowListener windowListener = null;
    private boolean defaultCloseOperationSet = false;
    private int defaultCloseOperation = JFrame.EXIT_ON_CLOSE;
    private List<Component> components = new ArrayList<>();
    private List<Object[]> componentsWithConstraints = new ArrayList<>();
    private boolean visible = false;

    public JFrameBuilder() {
    }

    public JFrameBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public JFrameBuilder setSize(int width, int height) {
        this.width = width;
        this.height = height;
        return this;
    }

    public JFrameBuilder setResizable(boolean resizable) {
        this.resizable = resizable;
        return this;
    }

    public JFrameBuilder setLayout(LayoutManager layout) {
        this.layout = layout;
        return this;
    }

    public JFrameBuilder setWindowListener(WindowListener windowListener) {
        this.windowListener = windowListener;
        return this;
    }

    public JFrameBuilder setDefaultCloseOperation(int defaultCloseOperation) {
        this.defaultCloseOperation = defaultCloseOperation;
        this.defaultCloseOperationSet = true;
        return this;
    }

    public JFrameBuilder add(Component component) {
        this.components.add(component);
        return this;
    }

    public JFrameBuilder add(Component component, Object constraints) {
        this.componentsWithConstraints.add(new Object[]{component, constraints});
        return this;
    }

    public JFrameBuilder setVisible(boolean visible) {
        this.visible = visible;
        return this;
    }

    public JFrame build() {
        JFrame frame = new JFrame();
        frame.setTitle(this.title);
        frame.setSize(this.width, this.height);
        frame.setResizable(this.resizable);
        if (this.layout != null) {
            frame.setLayout(this.layout);
        }
        if (this.windowListener != null) {
            frame.addWindowListener(this.windowListener);
        }
        if (this.defaultCloseOperationSet) {
            frame.setDefaultCloseOperation(this.defaultCloseOperation);
        }
        for (Component component : this.components) {
            frame.add(component);
        }
        for (Object[] componentWithConstraints : this.componentsWithConstraints) {
            frame.add((Component) componentWithConstraints[0], componentWithConstraints[1]);
        }
        frame.setVisible(this.visible);
        return frame;
    }
}
