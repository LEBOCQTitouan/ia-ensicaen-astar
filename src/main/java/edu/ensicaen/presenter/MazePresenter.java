package edu.ensicaen.presenter;

import edu.ensicaen.model.maze.Maze;

public class MazePresenter implements Presenter {
    private Maze model;

    public MazePresenter() {

    }

    @Override
    public void updateUI() {

    }

    @Override
    public void updateModel() {

    }

    @Override
    public void next() {
        updateModel();
        updateUI();
    }
}
