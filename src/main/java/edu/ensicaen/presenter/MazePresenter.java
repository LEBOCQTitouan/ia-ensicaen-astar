package edu.ensicaen.presenter;

public class MazePresenter implements Presenter {
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
