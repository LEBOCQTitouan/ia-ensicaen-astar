package edu.ensicaen.app;

import edu.ensicaen.presenter.MazePresenter;
import edu.ensicaen.util.Sequencer;
import edu.ensicaen.view.display.AppFrame;

import javax.swing.*;

public class App implements Sequencer {
    private final MazePresenter presenter;
    private final AppFrame frame;

    public App() {
        presenter = new MazePresenter();
        frame = new AppFrame();
    }

    public void setup() {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    @Override
    public void next() {
        presenter.next();
    }
}
