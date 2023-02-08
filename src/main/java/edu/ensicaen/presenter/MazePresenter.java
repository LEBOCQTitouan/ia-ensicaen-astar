package edu.ensicaen.presenter;

import edu.ensicaen.model.agent.Astar.Astar;
import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.maze.Maze;
import edu.ensicaen.model.maze.generation.MazeRandomGeneration;
import edu.ensicaen.view.display.MazePanel;
import edu.ensicaen.view.logic.CellView;

// TODO update only when needed
public class MazePresenter implements Presenter {
    private final MazePanel display;
    private Maze model;
    private Astar agent;
    private boolean updateModel;
    private boolean regenerateMaze;
    private boolean updateUI;

    public MazePresenter() {
        display = new MazePanel();
        updateUI = true;
        updateModel = true;
        regenerateMaze = true;
    }

    // TODO metric based on number of cells and display size
    private int getMetrics() {
        return 10;
    }

    @Override
    public void updateUI() {
        if (updateUI) {
            display.clearDisplayables();

            for (int i = 0; i < model.getCells().length; i++) {
                for (int j = 0; j < model.getCells()[i].length; j++) {
                    Cell current = model.getCell(i, j);
                    display.addDisplayable(new CellView(
                            i * getMetrics(),
                            j * getMetrics(),
                            getMetrics(),
                            getMetrics(),
                            current.getType())
                    );
                }
            }

            display.revalidate();
            display.repaint();
            updateUI = false;
        }
    }

    @Override
    public void updateModel() {
        if (updateModel) {
            if (regenerateMaze) {
                model = Maze.generateMaze(100, 100, new MazeRandomGeneration());
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
