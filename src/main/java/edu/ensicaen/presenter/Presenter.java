package edu.ensicaen.presenter;

import edu.ensicaen.util.Sequencer;

public interface Presenter extends Sequencer {
    void updateUI();
    void updateModel();
}
