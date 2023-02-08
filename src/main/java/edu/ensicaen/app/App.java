package edu.ensicaen.app;

import edu.ensicaen.presenter.MazePresenter;
import edu.ensicaen.util.Sequencer;
import edu.ensicaen.view.display.AppFrame;

import javax.swing.*;

public class App implements Sequencer {
    private final MazePresenter presenter;
    private final AppFrame frame;
    public final static int frameRate = 60;

    public App() {
        presenter = new MazePresenter();
        frame = new AppFrame(presenter);
    }

    public void setup() {
        frame.setResizable(false);
        frame.pack();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void next() {
        presenter.next();
    }
}
