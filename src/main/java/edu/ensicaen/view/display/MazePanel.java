package edu.ensicaen.view.display;

import edu.ensicaen.view.logic.displayInterface.Displayable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MazePanel extends JPanel {
    private final ArrayList<Displayable> displayables;

    public MazePanel() {
        displayables = new ArrayList<>();
    }

    public void addDisplayable(Displayable displayable) {
        displayables.add(displayable);
    }

    public void removeDisplayable(Displayable displayable) {
        displayables.remove(displayable);
    }

    public void clearDisplayables() {
        displayables.clear();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Displayable displayable : displayables) {
            displayable.display(g);
        }
    }
}
