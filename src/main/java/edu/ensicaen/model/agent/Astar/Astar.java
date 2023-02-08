package edu.ensicaen.model.agent.Astar;

import edu.ensicaen.model.agent.Agent;
import edu.ensicaen.model.agent.Astar.Heuristic.Heuristic;
import edu.ensicaen.model.agent.Astar.Heuristic.ManhattanHeuristic;
import edu.ensicaen.model.cell.Cell;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Astar implements Agent {
    private final AstarCell[][] cells;
    private final AstarCell start;
    private final AstarCell end;
    private final PriorityQueue<AstarCell> openList;
    private final ArrayList<AstarCell> closedList;
    private Heuristic heuristic;

    public Astar(AstarCell[][] cells, AstarCell start, AstarCell end) {
        this(cells, start, end, new ManhattanHeuristic());
    }
    public Astar(Cell[][] cells, Cell start, Cell end, Heuristic heuristic) {
        openList = new PriorityQueue<>();
        closedList = new ArrayList<>();
        this.heuristic = heuristic;

        this.start = new AstarCell(start.getType(), start.getX(), start.getY());
        this.end = new AstarCell(end.getType(), end.getX(), end.getY());
        this.cells = new AstarCell[cells.length][cells[0].length];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                this.cells[i][j] = new AstarCell(cells[i][j].getType(), i, j);
            }
        }

        openList.add(this.start);
    }

    @Override
    public void compute() {
        // TODO
    }

    @Override
    public void computeStep() {
        // TODO
    }
}
