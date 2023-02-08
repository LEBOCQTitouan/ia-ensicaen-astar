package edu.ensicaen.presenter;

import edu.ensicaen.model.agent.Agent;
import edu.ensicaen.model.agent.Astar.Astar;
import edu.ensicaen.model.agent.AvailableAgents;
import edu.ensicaen.model.cell.Cell;
import edu.ensicaen.model.maze.Maze;
import edu.ensicaen.model.maze.generation.MazeRandomGeneration;
import edu.ensicaen.view.display.MazePanel;
import edu.ensicaen.view.logic.CellView;
import edu.ensicaen.view.logic.ColorProxyForCell;

// TODO update only when needed
public class MazePresenter implements Presenter {
    private final MazePanel display;
    private Maze model;
    private Agent agent;
    private boolean updateModel;
    private boolean regenerateMaze;
    private boolean updateUI;

    public MazePresenter() {
        display = new MazePanel();
        updateUI = true;
        updateModel = true;
        regenerateMaze = true;
        // TODO dynamic agent declaration
    }

    // TODO metric based on number of cells and display size
    private int getMetrics() {
        return 20;
    }

    @Override
    public void updateUI() {
        if (updateUI) {
            display.clearDisplayables();

            for (int i = 0; i < agent.getCells().length; i++) {
                for (int j = 0; j < agent.getCells()[i].length; j++) {
                    int x = i * getMetrics();
                    int y = j * getMetrics();
                    display.addDisplayable(new CellView(
                            x,
                            y,
                            getMetrics(),
                            getMetrics(),
                            new ColorProxyForCell(
                                    agent.getCell(i, j).getType(),
                                    agent.getCell(i, j).getCost()
                            )
                        )
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
                // TODO dynamic maze generation
                model = Maze.generateMaze(30, 30, new MazeRandomGeneration());
                agent = model.getAgent(AvailableAgents.ASTAR);
                regenerateMaze = false;
            }
            // update model evolution if needed (trap, entity, etc.) here
            updateModel = false;
            // TODO implement button to compute all in one go
            if (!agent.isFinished())
                stepAgent();
        }
    }

    public void stepAgent() {
        agent.computeStep();
        updateModel = true;
        updateUI = true;
    }

    public void computeAgent() {
        agent.compute();
        updateModel = true;
        updateUI = true;
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
