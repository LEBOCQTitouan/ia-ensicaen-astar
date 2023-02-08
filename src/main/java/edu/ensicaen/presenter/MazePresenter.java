package edu.ensicaen.presenter;

import edu.ensicaen.model.maze.Maze;
import edu.ensicaen.view.display.MazePanel;
import edu.ensicaen.view.logic.Test;

// TODO update only when needed
public class MazePresenter implements Presenter {
    private final MazePanel display;
    private Maze model;
    private boolean updateModel;
    private boolean regenerateMaze;
    private boolean updateUI;

    public MazePresenter() {
        display = new MazePanel();
        updateUI = true;
        updateModel = true;
        regenerateMaze = false;
    }

    @Override
    public void updateUI() {
        if (updateUI) {
            display.clearDisplayables();
            display.addDisplayable(new Test());
            display.revalidate();
            display.repaint();
            updateUI = false;
        }
    }

    @Override
    public void updateModel() {
        if (updateModel) {
            if (regenerateMaze) {
                model = Maze.generateMaze(100, 100);
                regenerateMaze = false;
            }
            // TODO update model
            updateModel = false;
        }
    }

    @Override
    public void next() {
        updateModel();
        updateUI();
    }

    public MazePanel getDisplay() {
        return display;
    }
}
