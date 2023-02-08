package edu.ensicaen.view.display;

import edu.ensicaen.presenter.MazePresenter;

import javax.swing.*;

public class AppFrame extends JFrame {
    private final MazePanel mazePanel;
    public AppFrame(MazePresenter presenter) {
        super("A* Pathfinding");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mazePanel = presenter.getDisplay();
        add(mazePanel);

        // TODO change temporary fixing the size of the display
        setResizable(false);
        setSize(800, 600);
        // end TODO

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public MazePanel getMazePanel() {
        return mazePanel;
    }
}
