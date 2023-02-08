package edu.ensicaen.model.agent.Astar;

import edu.ensicaen.model.agent.Agent;
import edu.ensicaen.model.agent.Astar.Heuristic.Heuristic;
import edu.ensicaen.model.agent.Astar.Heuristic.ManhattanHeuristic;
import edu.ensicaen.model.cell.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Astar implements Agent {
    private final AstarCell[][] cells;
    private final AstarCell start;
    private final AstarCell end;
    private AstarCell current;
    private final PriorityQueue<AstarCell> openList;
    private final ArrayList<AstarCell> closedList;
    private final Heuristic heuristic;

    public Astar(Cell[][] cells, Cell start, Cell end) {
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
    public AstarCell[][] getCells() {
        return cells;
    }

    @Override
    public AstarCell getCell(int x, int y) {
        return cells[x][y];
    }

    @Override
    public void compute() {
        while (!isFinished()) {
            computeStep();
        }
    }

    private List<AstarCell> getNeighbours(Cell cell) {
        List<AstarCell> neighbours = new ArrayList<>();
        int x = cell.getX();
        int y = cell.getY();

        if (x > 0) { // TOP
            neighbours.add(cells[x - 1][y]);
            if (y > 0) { // TOP LEFT
                neighbours.add(cells[x - 1][y - 1]);
            }
            if (y < cells[0].length - 1) { // TOP RIGHT
                neighbours.add(cells[x - 1][y + 1]);
            }
        }
        if (x < cells.length - 1) { // BOTTOM
            neighbours.add(cells[x + 1][y]);
            if (y > 0) { // BOTTOM LEFT
                neighbours.add(cells[x + 1][y - 1]);
            }
            if (y < cells[0].length - 1) { // BOTTOM RIGHT
                neighbours.add(cells[x + 1][y + 1]);
            }
        }
        if (y > 0) { // LEFT
            neighbours.add(cells[x][y - 1]);
        }
        if (y < cells[0].length - 1) { // RIGHT
            neighbours.add(cells[x][y + 1]);
        }

        return neighbours;
    }

    @Override
    public void computeStep() {
        if (openList.isEmpty()) { // no path available
            current = end;
        }

        current = openList.remove();
        if (current.equals(end)) {
            System.out.println("Path found");
        }
        for (AstarCell neighbour : getNeighbours(current)) {
            if (!closedList.contains(neighbour)) {
                neighbour.setParent(current);
                neighbour.setH(heuristic.compute(neighbour.getX(), neighbour.getY(), end.getX(), end.getY()));
                openList.add(neighbour);
            }
        }
        closedList.add(current);
    }

    @Override
    public boolean isFinished() {
        return end.equals(current);
    }
}
